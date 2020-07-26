<?php 

include 'connection.php';

 $t_name = $_POST['t_name'];
 $t_post = $_POST['t_post'];
 $t_pass = $_POST['t_pass'];
 $t_contact = $_POST['t_contact'];
 $t_email = $_POST['t_email'];
 
 $sql="UPDATE teacher_registration SET t_name='$t_name',t_post='$t_post',t_pass='$t_pass',t_contact='$t_contact' where t_email ='$t_email'"; 
 
 if(mysqli_query($con,$sql)){
	//echo "Success";
	echo json_encode(array('response' => 'success'));
 }else{
	//echo "Error";
	echo json_encode(array('response' => 'Something Wrong'));
 }
 
 
 
 


?>