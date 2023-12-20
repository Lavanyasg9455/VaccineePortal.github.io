package com.tap.vaccine.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.entity.MemberEntity;
import com.tap.vaccine.exception.InvalidMemberCredentials;
import com.tap.vaccine.service.MemberService;

@Controller
public class MemberController {

	private MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {

		System.out.println("Invoked MemberService()");
		this.memberService = memberService;
	}

	@RequestMapping(value = "/getAddMemberPage")
	public String getAddMemberPage() {

		return "/WEB-INF/Member.jsp";
	}
	
	@RequestMapping(value="/getBackHomePage")
	public String getMemberPage() {
		
		return "/WEB-INF/Login.jsp";
	}

	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public String addMember(@RequestParam String memberName, @RequestParam String gender,
			@RequestParam String dateOfBirth, @RequestParam String idProof, @RequestParam String idProofNo,
			@RequestParam String vaccineType, @RequestParam String dose, Model model,HttpServletRequest request) throws InvalidMemberCredentials {

		
		HttpSession session = request.getSession();
		String userEmail = (String) session.getAttribute("userEmail");
		System.out.println(userEmail);
		System.out.println("this is AddMember in controller");
		
		if(memberService.checkMemberCount(userEmail)) {
		try {
			boolean valid = memberService.validateMemberData(memberName, gender, dateOfBirth, idProof, idProofNo,
					vaccineType, dose);
			if (valid) {
				boolean chcekIdProof = memberService.idProofNoValid(idProofNo);
				if (chcekIdProof) {
					boolean save = memberService.saveMemberDetails(memberName, gender, dateOfBirth, idProof, idProofNo,
							vaccineType, dose,userEmail);
					if (save) {
						int memberCount = memberService.getMemberCount(userEmail);
						memberService.updateMemberCount(userEmail, memberCount);
						model.addAttribute("memberMessage", "Member Added Succesfully..");
					}
				} else {
					model.addAttribute("memberErrorMessage", "ID Proof Number already exist!Try With Other..");
				}

			}
		} catch (InvalidMemberCredentials e) {
			model.addAttribute("memberErrorMessage", e.getMessage());
		}
		}else {
			model.addAttribute("memberErrorMessage", "Your limit has exceeded , NOTE : You can only add upto 4 members");
		}
		return "/WEB-INF/Member.jsp";

	}
	
	@RequestMapping(value="/viewAllButton")
	public String viewAllMembers(Model model,HttpServletRequest request) {
		
		System.out.println("Invoked viewAllMembers()..");
		
		HttpSession session = request.getSession();
		String userEmail = (String) session.getAttribute("userEmail");
		
		List<MemberEntity> allMembers = memberService.getAllMembers(userEmail);
		if(allMembers!=null) {
			model.addAttribute("members", allMembers);
			return "/WEB-INF/Member.jsp";
		}else {
			model.addAttribute("tableErrorMessage","Table is empty!Cannot retreive data..");
		}
		return "/WEB-INF/Member.jsp";
		
	}

	@RequestMapping(value = "/editMember/{memberId}")
	public String editMemberDetailsById(@PathVariable int memberId, Model model) {

		System.out.println("Invoked editMemberDetailsById()" + memberId);
		
		MemberEntity entity = memberService.getMemberEntityByID(memberId);
		model.addAttribute("ID", entity.getMemberId());
		model.addAttribute("NAME", entity.getMemberName());
		model.addAttribute("GENDER", entity.getGender());
		model.addAttribute("DATE_OF_BIRTH", entity.getDateOfBirth());
		model.addAttribute("ID_PROOF", entity.getIdProof());
		model.addAttribute("ID_PROOF_NO", entity.getIdProofNo());
		model.addAttribute("VACCINE_TYPE", entity.getVaccineType());
		model.addAttribute("DOSE", entity.getDose());
	
		return "/WEB-INF/UpdateMember.jsp";

	}
	
	@RequestMapping(value = "/editMember/updateMember/{memberId}", method = RequestMethod.POST)
	public String updateMemberDetails(@PathVariable int memberId,
			@RequestParam String memberName, 
			@RequestParam String gender,
			@RequestParam String dateOfBirth,
			@RequestParam String idProof,
			@RequestParam String idProofNo,
			@RequestParam String vaccineType, 
			@RequestParam String dose,Model model,HttpServletRequest request) throws InvalidMemberCredentials {
		
		System.out.println("Invoked updateMemberDetails()..");
		
		HttpSession session = request.getSession();
		String userEmail = (String) session.getAttribute("userEmail");
		System.out.println(userEmail);
		System.out.println("this is AddMember in controller");
		
		try {
			
			boolean valid = memberService.validateMemberData(memberName, gender, dateOfBirth, idProof, idProofNo,
					vaccineType, dose);
			if(valid) {
				boolean update=memberService.updateMemberEntity(memberId, memberName, gender, dateOfBirth, idProof, idProofNo, vaccineType, dose, userEmail);
				if(update) { 
					 return "redirect:/viewAllButton";
				}else {
					 model.addAttribute("updateErrorMessage", "Invalid Data! Please provide valid data.." );
					 return "/WEB-INF/UpdateMember.jsp";
				}
			}
		}catch(InvalidMemberCredentials e) {
			
			model.addAttribute("updateErrorMessage", e.getMessage());
			return "/WEB-INF/UpdateMember.jsp";
		}
		
		return "forward:/WEB-INF/Member.jsp";
	}
	
	@RequestMapping(value="/deleteMember/{idProofNo}")
	  public String deleteMemberEntityByIdProofNo(@PathVariable String idProofNo,Model model,HttpServletRequest request) {
		  
			System.out.println("Invoked deleteMemberEntityByIdProofNo()" + idProofNo);
			MemberEntity entity = memberService.getMemberEntityByIdProofNo(idProofNo);
			memberService.deleteMemberEntityByIdProofNo(idProofNo);
			HttpSession session = request.getSession();
			String userEmail = (String) session.getAttribute("userEmail");
			int memberCount = memberService.getMemberCount(userEmail);
			memberService.decreaseMemberCount(userEmail, memberCount);
			return "redirect:/viewAllButton";

		}

}