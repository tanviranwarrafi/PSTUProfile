<?php

include 'connection.php';

$t_email = $_POST['t_email'];


$sql = "SELECT * FROM teacher_registration WHERE t_email='$t_email'";

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