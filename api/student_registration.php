<?php 

include 'connection.php';
 
if($con){
	
	$name = $_POST['name'];
	$Id_no = $_POST['Id_no'];
	$reg_no = $_POST['reg_no'];
	$pass = $_POST['pass'];
	$faculty = $_POST['faculty'];
	$batch = $_POST['batch'];
	$contact = $_POST['contact'];
	$email = $_POST['email'];
	
	$query = "SELECT * FROM student_registration WHERE Id_no='$Id_no'";
 
	$result = mysqli_query($con,$query);
	$row = mysqli_fetch_assoc($result);
 
	if(isset($row['name'])) {
		echo json_encode(array('response' => 'registered'));
	} else {
		$sql = "insert into student_registration (name,Id_no,reg_no,pass,faculty,batch,contact,email) values('$name','$Id_no','$reg_no','$pass','$faculty','$batch','$contact','$email')";
		
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