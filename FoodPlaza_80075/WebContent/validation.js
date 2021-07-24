//Add Food Form validation
//Hide error mesages
//**********************************************************************************************************************************
//show hide msg for reg form
function HideRegMsg(){
	var cname = document.getElementById("cname").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	
	var address = document.getElementById("address").value;
	var contact = document.getElementById("contact").value;

	if (cname!="") {
		document.getElementById("cnameError").innerHTML = "";
		
	}
	if (email!="") {
		document.getElementById("emailError").innerHTML = "";
	
	}
	if (password!="") {
		document.getElementById("passwordError").innerHTML = "";
	
	}

	
	if (address!="") {
		document.getElementById("addressError").innerHTML = "";
	
	}

	if (contact!="") {
	document.getElementById("contactError").innerHTML = "";
	
}

}
//show hide msg for Add food form
function HideMsg() {
	var Food_Category = document.getElementById("Food_Category").value;
	var Food_Name = document.getElementById("Food_Name").value;
	var Food_Price = document.getElementById("Food_Price").value;
	if (Food_Category!= 0) {
		document.getElementById("Food_CategoryError").innerHTML = "";

	}
	if (Food_Name!= "") {
		document.getElementById("Food_NameError").innerHTML = "";
	}
	if (Food_Price!= "") {
		document.getElementById("Food_PriceError").innerHTML = "";

	}
}
// **********************************************************************************************************************************
// show hide msg for Login form
function HideLogin() {
	
	var user = document.getElementById("user").value;
	var cname = document.getElementById("cname").value;
	var password = document.getElementById("password").value;

	if (user!=0) {
		document.getElementById("userError").innerHTML = " ";

	}
	if (cname!="") {
		
		document.getElementById("cnameError").innerHTML = "";

	}
	if (password!="") {
		document.getElementById("passwordError").innerHTML = "";

	}

}
// **********************************************************************************************************************************
// show hide msg for feedback form
function HideMsgForFeeback() {
	var email = document.getElementById("email").value;
	var message = document.getElementById("message").value;
	if (email != "") {
		document.getElementById("emailError").innerHTML = "";

	}

	if (message != "") {
		document.getElementById("msgError").innerHTML = "";
	}
}
// ######################################## ERROR MSGS
// ###############################################################################

// **********************************************************************************************************************************
// show error msg for Add Food form
function validateAddFood() {
	var Food_Category = document.getElementById("Food_Category").value;
	var Food_Name = document.getElementById("Food_Name").value;
	var Food_Price = document.getElementById("Food_Price").value;
	
	var namePattern = /^[a-zA-Z ]{2,30}$/;
	var number = /[0-9]/
	if (Food_Category == 0) {
		document.getElementById("Food_CategoryError").innerHTML = "Please select food category";
		return false;
	}
	if (Food_Name == "") {
		document.getElementById("Food_NameError").innerHTML = "Please select food name";
		return false;
	}else if(!namePattern.test(Food_Name)){
		document.getElementById("Food_NameError").innerHTML = "Single letter for food name is invalid ";
		return false;
		
	}
	if (Food_Price == "") {
		document.getElementById("Food_PriceError").innerHTML = "Please select food price";
		return false;
	}else if(!number.test(Food_Price)){
		document.getElementById("Food_PriceError").innerHTML = "Please enter a valid food price";
		return false;
	}

	return true;
}
// **********************************************************************************************************************************
// show error msg for Feedback form
function validateFeedbackForm() {

	var email = document.getElementById("email").value;

	var message = document.getElementById("message").value;
	// alert(message)
	var EmailPattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

	// email
	if (email == "") {
		document.getElementById("emailError").innerHTML = "Email field is blank";
		return false;
	} else if (EmailPattern.test(email) == false) {
		document.getElementById("emailError").innerHTML = "Please enter valid email";
		return false;
	}

	// textArea
	if (message == "") {
		document.getElementById("msgError").innerHTML = "Please enter the feedback!!";
		return false;
	}

	return true;
}

// **********************************************************************************************************************************
// show error msg for Login form
function validateLogin() {

	var user = document.getElementById("user").value;
	
	var email = document.getElementById("cname").value;
	var password = document.getElementById("password").value;
	
	var EmailPattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	
	var lower = /[a-z]/;
	var upper = /[A-Z]/;
	var specialchar = /^[!|@|#|$|%|^|&|*]$/;
	var number = /[0-9]/

	// user
	if (user == 0) {
		document.getElementById("userError").innerHTML = "Please select user";
		return false;
	}
	
	// username
	// email
	if (email == "") {
		document.getElementById("cnameError").innerHTML = "Username field is blank";
		return false;
	} else if (EmailPattern.test(email) == false) {
		document.getElementById("cnameError").innerHTML = "Please enter valid Username";
		return false;
	}
	// password
	if (password == "") {
		document.getElementById("passwordError").innerHTML = "Password field is blank!!";
		return false;
	} else if (password.length < 8) {
		document.getElementById("passwordError").innerHTML = "Please make sure password is longer than 8 characters.";
		return false;
	} else if (!lower.test(password)) {
		document.getElementById("passwordError").innerHTML = "Please make sure password includes a lowercase letter.";
		return false;
	} else if (!number.test(password)) {
		document.getElementById("passwordError").innerHTML = "Please make sure password includes a number.";
		return false;
	} else if (!upper.test(password)) {
		document.getElementById("passwordError").innerHTML = "Please make sure password includes a uppercase letter.";
		return false;
	}
	return true;
}
//**********************************************************************************************************************************
// show error msg for registration form
function validateRegistration() {
	
	var cname = document.getElementById("cname").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var address = document.getElementById("address").value;
	var contact = document.getElementById("contact").value;

	var EmailPattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	var namePattern = /^[a-zA-Z ]{2,30}$/;
	var lower = /[a-z]/;
	var upper = /[A-Z]/;
	var specialchar = /^[!|@|#|$|%|^|&|*]$/;
	var number = /[0-9]/;
	var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
	var phonenoPlus = /^\+?([0-9]{2})\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4})$/;
	// name
	if (cname == "") {
		document.getElementById("cnameError").innerHTML = "Please enter name";
		return false;
	} else if (!namePattern.test(cname)) {

		document.getElementById("cnameError").innerHTML = "Please enter valid name";
		return false;
	}
	// email
	if (email == "") {
		document.getElementById("emailError").innerHTML = "Email field is blank";
		return false;
	} else if (EmailPattern.test(email) == false) {
		document.getElementById("emailError").innerHTML = "Please enter valid email";
		return false;
	}
	// password
	if (password == "") {
		document.getElementById("passwordError").innerHTML = "Password field is blank!!";
		return false;
	} else if (password.length < 8) {
		document.getElementById("passwordError").innerHTML = "Please make sure password is longer than 8 characters.";
		return false;
	} else if (!lower.test(password)) {
		document.getElementById("passwordError").innerHTML = "Please make sure password includes a lowercase letter.";
		return false;
	} else if (!number.test(password)) {
		document.getElementById("passwordError").innerHTML = "Please make sure password includes a number.";
		return false;
	} else if (!upper.test(password)) {
		document.getElementById("passwordError").innerHTML = "Please make sure password includes a uppercase letter.";
		return false;
	}

	// address
	if (address == "") {
		document.getElementById("addressError").innerHTML = "Please enter the address";
		return false;
	}
	//	contact
	if (contact == "") {
	document.getElementById("contactError").innerHTML = "Please enter contact number";
	return false;
} else if (!contact.match(phoneno)) {
	document.getElementById("contactError").innerHTML = "Please Enter valid mobile number";
	return false;
}
else if (!contact.match(phonenoPlus)) {
	document.getElementById("contactError").innerHTML = "Please Enter valid mobile number";
	return false;
}
	return true;
}
//**********************************************************************************************************************************
//show error msg for Update password form
function checkForm()
{
	alert("CheckForm!!");
 var oldP=document.getElementById("cpassword").value;
 var newP=document.getElementById("npswd").value;
 var confirmP =document.getElementById("confpswd").value;

 if(oldP!=""&&newP!=""&&confirmP!="")
 {
   if(oldP!=newP)
   {
     if(newP==confirmP)
      {
       return true;
      }
      else
       {
         alert("Confirm password is not same as you new password.");
         return false;
       }
   }
   else
  {
   alert(" This Is Your Old Password,Please Provide A New Password");
   return false;
  }
 }
 else
 {
  alert("All Fields Are Required");
  return false;
 }
 return true;
}