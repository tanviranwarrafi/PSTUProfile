<?php 

include 'connection.php';

 $Id_no = $_POST['Id_no'];
 $pass = $_POST['pass'];
 
 $sql = "SELECT * FROM student_registration WHERE Id_no='$Id_no' && pass='$pass'";
 
  $result=mysqli_query($con,$sql);
  
 if(mysqli_num_rows($result)>0){
	echo "Success";
 }else{
	echo "Error";
 }
 
?>