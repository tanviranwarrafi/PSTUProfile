<?php 

include 'connection.php';

if($con){
	
	$t_name = $_POST['t_name'];
	$t_post = $_POST['t_post'];
	$t_faculty = $_POST['t_faculty'];
	$t_dept = $_POST['t_dept'];
	$t_pass = $_POST['t_pass'];
	$t_email = $_POST['t_email'];
	$t_contact = $_POST['t_contact'];
 
	$query = "SELECT * FROM teacher_registration WHERE t_email='$t_email'";
 
	$result = mysqli_query($con,$query);
	$row = mysqli_fetch_assoc($result);
 
	if(isset($row['t_name'])) {
		echo json_encode(array('response' => 'registered'));
	} else {
		$sql = "insert into teacher_registration (t_name,t_post,t_faculty,t_dept,t_pass,t_contact,t_email) values('$t_name','$t_post','$t_faculty','$t_dept','$t_pass','$t_contact','$t_email')";
		
		if(mysqli_query($con,$sql)){
			echo json_encode(array('response' => 'success'));
		} else {
			echo json_encode(array('response' => 'Something Wrong'));
		}
	}
} 
else{
	echo json_encode(array('response' => 'Data Insert Failed'));
}

 mysqli_close($con);
 
?>