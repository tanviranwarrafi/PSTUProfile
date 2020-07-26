<?php

 include 'connection.php';

 $t_email = $_POST['t_email'];
 $t_pass = $_POST['t_pass'];
 
 //$encrypt_pass=md5($pass);
 
 $sql = "SELECT * FROM teacher_registration WHERE t_email='$t_email' && t_pass='$t_pass'";
 
 $result=mysqli_query($con,$sql);
  
 if(mysqli_num_rows($result)>0){
	echo "Success";
 }else{
	echo "Error";
 }
	

?>