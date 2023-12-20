function validate()
{
	console.log("validate function called")
    var un=document.getElementById("userName").value
    var unp=/^[a-zA-Z]+$/

    var ph=document.getElementById("mobileNo").value
    var php=/^[6-9]{1}[0-9]{9}$/

    var mailId=document.getElementById("emailId").value

    var pass=document.getElementById("password").value
    var passp=/[a-zA-Z][@_.#$!*^][0-9]/

    var conpass=document.getElementById("confirmPassword").value
    
    var dob = document.getElementById("dateOfBirth").value;
    var dobp = /^[0-9]{2}-[0-9]{2}-[0-9]{4}$/;

    if(un=="")
    {
        document.getElementById("msg").innerHTML="Enter the username"
        return false
    }
	
    if(un.match(unp))
    true
    else
    {
        document.getElementById("msg").innerHTML="Username should contain Alphabets only.."
        return false   
    }
    if(un.length<3)
    {
        document.getElementById("msg").innerHTML="Username should contain minimum 3 characters"
        return false   
    }
    if(un.length>8)
    {
        document.getElementById("msg").innerHTML="Username should contain maximum 8 characters"
        return false   
    }
    if(ph=="")
    {
        document.getElementById("msg1").innerHTML="Enter the Phone Number"
        return false
    }
    if(ph.match(php))
    true
    else
    {
        document.getElementById("msg1").innerHTML="Invalid Phone Number"
        return false   
    }
    if(mailId=="")
    {
        document.getElementById("msg2").innerHTML="Enter the Email"
        return false
    }
    if(pass=="")
    {
        document.getElementById("msg3").innerHTML="Enter the password"
        return false
    }
    if(pass.match(passp))
    true
    else
    {
        document.getElementById("msg3").innerHTML="Invalid Password!Password must contain atleast one speacial character and one numeric character and minimum 8 characters"
        return false  
    }
    if(conpass=="")
    {
        document.getElementById("msg4").innerHTML="Please Enter The Confirm Password"
        return false
    }
    if(conpass.match(pass))
    true
    else
    {
        document.getElementById("msg4").innerHTML="Password Sholud Not Match Try Again..."
        return false 
    }
    if (dob == "") {
        document.getElementById("msg5").innerHTML = "Enter the Date of Birth";
        return false;
    }
    if (!dob.match(dobp)) {
        document.getElementById("msg5").innerHTML = "Invalid Date of Birth format (DD-MM-YYYY)";
        return false;
    }
    
    return true;
     

}