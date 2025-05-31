function validatePasswords(event){

let pass1 = document.getElementById("pass1").value;

let pass2 = document.getElementById("pass2").value;

if(pass1 !== pass2){
	alert("Passwords do not match");
	pass1.value="";
	pass2.value="";
	event.preventDefault();
	return false;
}
return true;

}