<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<style>
  .inner_ubrn{
	color: black;
    background-color: #909000;;
    border: 2px solid darkblue;
    padding: 5px;
	position:relative;
 }
 .inner_patient {
    width: 990px;
    color: black;
    background-color: #909000;;
    border: 2px solid darkblue;
    padding: 5px;
	position:relative;
 }
 .outer {
    width: 1000px;
    color: black;
    background-color: #909000;
    border: 4px solid darkblue;
    padding: 5px;

 }
</style>
<html>
<head><title>New Referral</title></head>
<body>
	<b>Create New Referral</b><br>
	<br>
	<div class="outer">
		<form method="post">
		<input type="hidden" name="id" value=${referralCommand.id}/>
		<input type="hidden" name="description" value=${referralCommand.description} />

			<table>
			<tr>
			<td width=490px>
				<div class="inner_ubrn">
				<table>
					<tr>
						<td>UBRN</td>
						<td><input type="text" name="ubrn" value=${referralCommand.ubrn}></input></td>
					</tr>
					<tr>
						<td>Receipt Date(ddmmyyyyhhmm) *</td>
						<td><input type="text" name="createDate" value=${referralCommand.createDate} ></input></td>
					</tr>
				</table>
			    </div>
			</td>
			<td width=490px>
			<div class="inner_ubrn">
				<table>
					<tr>
						<td>Referral Type</td>
						<td><input type="text" name="type"  value=${referralCommand.type} /></td>
					</tr>
					<tr>
						<td>PPwT Procedure</td>
						<td><input type="text" name="type" value=${referralCommand.ppwtProcedure} /></td>
					</tr>
				</table>
			</div>
			</td>
			</tr>
			</table>
		<br><u>Patient Details</u>
		<div class="inner_patient">
			<table>
				<tr>
					<td>NHS Number *</td><td><input type="text" name="patient.nhsNumber" value=${referralCommand.patient.nhsNumber}/></td><td colspan=4></td>
				</tr>
				<tr>
					<td>Title</td><td><input type="text" name="title"/></td><td colspan=4></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="first_name"/></td>
					<td>Middle Name</td>
					<td><input type="text" name="middle_name"/></td>
					<td>Last Name</td>
					<td><input type="text" name="last_name"/></td>
				</tr>
				<tr>
					<td>Preferred Name</td>
					<td><input type="text" name="preferred_name"/></td>
					<td>DOB *</td>
					<td><input type="text" name="dob"/></td>
					<td>Gender</td>
					<td><input type="text" name="gender"/></td>
				</tr>
				<tr>
					<td>Ethnicity</td>
					<td><input type="text" name="ethnicity"/></td>
					<td colspan=4></td>

				</tr>
				<tr>
					<td>Address Line1</td>
					<td><input type="text" name="address_line_one"/></td>
					<td>Address Line2</td>
					<td><input type="text" name="address_line_two"/></td>
					<td>Address Line3</td>
					<td><input type="text" name="address_line_three"/></td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" name="city"/></td>
					<td>Country</td>
					<td><input type="text" name="counter"/></td>
					<td>Postcode</td>
					<td><input type="text" name="postcode"/></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="text" name="phone_number"/></td>
					<td>Mobile Number</td>
					<td><input type="text" name="mobile_number"/></td>
					<td>Email</td>
					<td><input type="text" name="email"/></td>
				</tr>
				<tr>
					<td>Primary Spoken Language</td>
					<td><input type="text" name="primary_spoken_language"/></td>
					<td>Secondary Spoken Language</td>
					<td><input type="text" name="secondary_spoken_language"/></td>
					<td>Written Language</td>
					<td><input type="text" name="written_language"/></td>
				</tr>
				<tr>
					<td>Interpreter Required</td>
					<td><input type="text" name="interpreter_required"/></td>
					<td>Assistance Required</td>
					<td><input type="text" name="assistance_required"/></td>
					<td colspan=2></td>
				</tr>
			</table>
		</div>
		<br><u>Referral's Details</u>
		<div class="inner_patient">
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="referral_name"/></td>
					<td rowspan=5 colspan=4>
						<div class="inner_ubrn">
							<u>IGR Destination</u>
							<table>
								<tr>
									<td>Name</td>
									<td><input type="text" name="igr_name"/></td>
									<td>Registered GP Name</td>
									<td><input type="text" name="registered_gp_name"/></td>
								</tr>
								<tr>
									<td>Speciality</td>
									<td><input type="text" name="igr_speciality"/></td>
									<td>Registered GP Practice Name</td>
									<td><input type="text" name="registered_gp_practice_name"/></td>
								</tr>
								<tr>
									<td>Practice/Clinic Name</td>
									<td><input type="text" name="igr_clinic_name"/></td>
									<td colspan=2></td>
								</tr>
								<tr>
									<td>Referred To</td>
									<td><input type="text" name="referred_to"/></td>
									<td colspan=2></td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
				<tr>
					<td>Role</td>
					<td><input type="text" name="role"/></td>
				</tr>
				<tr>
					<td>Speciality</td>
					<td><input type="text" name="speciality"/></td>
				</tr>
				<tr>
					<td>Practice/Clinic Name *</td>
					<td><input type="text" name="clinic_name"/></td>
				</tr>
				<tr>
					<td>Practice Code</td>
					<td><input type="text" name="practice_code"/></td>
				</tr>
				<tr>
					<td>Address Line1</td>
					<td><input type="text" name="referrer_address_line_one"/></td>
					<td>Address Line2</td>
					<td><input type="text" name="referrer_address_line_two"/></td>
					<td>Address Line3</td>
					<td><input type="text" name="referrer_address_line_three"/></td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" name="referrer_city"/></td>
					<td>Country</td>
					<td><input type="text" name="referrer_country"/></td>
					<td>Postcode</td>
					<td><input type="text" name="referrer_postcode"/></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="text" name="referrer_phone_number"/></td>
					<td>Fax Number</td>
					<td><input type="text" name="referrer_fax_number"/></td>
					<td>Mobile Number</td>
					<td><input type="text" name="referrer_mobile_number"/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="referrer_email"/></td>
					<td colspan=4></td>
				</tr>
			</table>
		</div>
		<br><u>Referral Context</u>
		<div class="inner_patient">
			<table>
				<tr>
					<td>Speciality</td>
					<td><input type="text" name="referral_speciality"/></td>
					<td>Reason</td>
					<td><input type="text" name="referral_reason"/></td>
					<td colspan=2></td>
				</tr>
				<tr>
					<td>Priority</td>
					<td><input type="text" name="referral_priority"/></td>
					<td>Provider</td>
					<td><input type="text" name="referral_provider"/></td>
					<td colspan=2></td>
				</tr>
				<tr>
					<td>Add Attachment 1</td>
					<td><input type="text" name="referral_attachment_one"/></td>
					<td>Share-point Link 1</td>
					<td><input type="text" name="referral_sharepoint_link_one"/></td>
					<td colspan=2></td>
				</tr>
				<tr>
					<td>Add Attachment 2</td>
					<td><input type="text" name="referral_attachment_two"/></td>
					<td>Share-point Link 2</td>
					<td><input type="text" name="referral_sharepoint_link_two"/></td>
					<td colspan=2></td>
				</tr>
				<tr>
					<td>Add Attachment 3</td>
					<td><input type="text" name="referral_attachment_three"/></td>
					<td>Share-point Link 3</td>
					<td><input type="text" name="referral_sharepoint_link_three"/></td>
					<td colspan=2></td>
				</tr>
			</table>
		</div>
		<br>
		<input type="submit"  value="Submit"/>
		<br>

	</form>
    </div>
</body>
</html>