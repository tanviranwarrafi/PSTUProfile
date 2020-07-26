<?php

include 'connection.php';

//if($con) echo ' success Connection';

$t_faculty = $_POST['t_faculty'];
$t_dept = $_POST['t_dept'];

$sql = "SELECT * FROM teacher_registration WHERE t_faculty='$t_faculty' && t_dept='$t_dept'";

$res = mysqli_query($con,$sql);

$result = array();

while($row = mysqli_fetch_array($res)){
		array_push($result,array(
				"t_name"=>$row["t_name"],
				"t_post"=>$row["t_post"],
				"t_faculty"=>$row["t_faculty"],
				"t_dept"=>$row["t_dept"],
				"t_pass"=>$row["t_pass"],
				"t_contact"=>$row["t_contact"],
				"t_email"=>$row["t_email"]
			)
		);
	}
	echo json_encode(array("result"=>$result));

?>