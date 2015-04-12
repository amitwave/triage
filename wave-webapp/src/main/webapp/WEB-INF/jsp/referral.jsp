<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<form method=post>
		<form:hidden path="referralCommand.id"/>

		<table>
			<tr>
				<td width=490px>
					<div class="inner_ubrn">
						<table>
							<tr>
								<td>UBRN</td>
								<td><input type="text" name="ubrn" value=${referralCommand.ubrn}></td>
							</tr>
							<tr>
								<td>Receipt Date(dd/MM/YYYY) *</td>
								<td><input type="text" name="createDate" value=${referralCommand.createDate}></td>
							</tr>
						</table>
					</div>
				</td>
				<td width=490px>
					<div class="inner_ubrn">
						<table>
							<tr>
								<td>Referral Type</td>
								<td><input type="text" name="type"  value=${referralCommand.type}></td>
							</tr>
							<tr>
								<td>PPwT Procedure</td>
								<td><input type="text" name="description" value=${referralCommand.description}></td>
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
					<td>NHS Number *</td>
					<td><input type="text" name="patient.nhsNumber" value=${referralCommand.patient.nhsNumber}></td>
					<td colspan=4></td>
				</tr>
				<tr>
					<td>Title</td>
					<td>
						<form:select path="referralCommand.patient.name.title.id">

							<c:forEach items="${titleList}" var="title">
							<form:option value= "${title.id}" label="${title.displayName}"/>
							</c:forEach>

						</form:select>
					</td>
					<td colspan=4></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="patient.name.firstName" value=${referralCommand.patient.name.firstName}></td>
					<td>Middle Name</td>
					<td><input type="text" name="patient.name.middleName" value=${referralCommand.patient.name.middleName}></td>
					<td>Last Name</td>
					<td><input type="text" name="patient.name.lastName" value=${referralCommand.patient.name.lastName}></td>
				</tr>
				<tr>
					<td>Preferred Name</td>
					<td><input type="text" name="patient.name.preferredName" value=${referralCommand.patient.name.preferredName}></td>
					<td>DOB *</td>
					<td><input type="text" name="patient.dateOfBirth" value=${referralCommand.patient.dateOfBirth}></td>
					<td>Gender</td>
					<td>

						<c:forEach var="gender" items="${genders}">
							<form:radiobutton path="referralCommand.patient.gender" value="${gender}" label="${gender}"></form:radiobutton>
						</c:forEach>

					</td>
				</tr>
				<tr>
					<td>Ethnicity</td>

					<td>


						<form:select path="referralCommand.patient.ethnicity.id">
							<form:option value="-1" label="Select"/>
							<c:forEach items="${ethnicity}" var="ethnicityItem">
								<form:option value="${ethnicityItem.id}" label="${ethnicityItem.displayName}"/>
							</c:forEach>

						</form:select>

					</td>
					<td colspan=4></td>

				</tr>
				<tr>
					<td>Address Line1</td>
					<td><input type="text" name="patient.address.line1" value=${referralCommand.patient.address.line1}></td>
					<td>Address Line2</td>
					<td><input type="text" name="patient.address.line2"  value=${referralCommand.patient.address.line2}></td>
					<td>Address Line3</td>
					<td><input type="text" name="patient.address.line3"  value=${referralCommand.patient.address.line3}></td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" name="patient.address.city"  value=${referralCommand.patient.address.city}></td>
					<td>Country</td>
					<td><input type="text" name="patient.address.country"  value=${referralCommand.patient.address.country}></td>
					<td>Postcode</td>
					<td><input type="text" name="patient.address.postCode"  value=${referralCommand.patient.address.postCode}></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="text" name="patient.contactDetails.phone" value=${referralCommand.patient.contactDetails.phone}></td>
					<td>Mobile Number</td>
					<td><input type="text" name="patient.contactDetails.mobile" value=${referralCommand.patient.contactDetails.mobile}></td>
					<td>Email</td>
					<td><input type="text" name="patient.contactDetails.email" value=${referralCommand.patient.contactDetails.email}></td>
				</tr>
				<tr>
					<td>Primary Spoken Language</td>
					<td><input type="text" name="patient.primarySpokenLanguage" value=${referralCommand.patient.primarySpokenLanguage}></td>
					<td>Secondary Spoken Language</td>
					<td><input type="text" name="patient.secondarySpokenLanguage"  value=${referralCommand.patient.secondarySpokenLanguage}></td>
					<td>Written Language</td>
					<td><input type="text" name="patient.writtenLanguage"  value=${referralCommand.patient.writtenLanguage}></td>
				</tr>
				<tr>
					<td>Interpreter Required</td>
					<td>
						<form:select path="referralCommand.patient.interpreterRequired">
							<form:option value="False" label="False" />
							<form:option value="True" label="True" />
						</form:select>
					</td>
					<td>Assistance Required</td>
					<td>
						<form:select path="referralCommand.patient.assistanceRequired">
							<form:option value="False" label="False" />
							<form:option value="True" label="True" />
						</form:select>
					</td>
					<td colspan=2></td>
				</tr>
			</table>
		</div>
		<br><u>Referrer's Details</u>
		<div class="inner_patient">
			<table>
				<tr>
					<td>Title</td>
					<td>
						<form:select path="referralCommand.referrer.name.title.id">

							<c:forEach items="${titleList}" var="title">
								<form:option value= "${title.id}" label="${title.displayName}"/>
							</c:forEach>

						</form:select>
					</td>
					<td colspan=4></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="referrer.name.preferredName" value=${referralCommand.referrer.name.preferredName}></td>
					<td rowspan=5 colspan=4>
						<div class="inner_ubrn">
							<u>IGR Destination</u>
							<table>
								<tr>
									<td>Name</td>
									<td><input type="text" name="referrer.igrDestination.name" value=${referralCommand.referrer.igrDestination.name}></td>
									<td>Registered GP Name</td>
									<td><input type="text" name="referrer.igrDestination.registeredName" value=${referralCommand.referrer.igrDestination.registeredName}></td>
								</tr>
								<tr>
									<td>Specialty</td>
									<td><input type="text" name="referrer.igrDestination.specialty" value=${referralCommand.referrer.igrDestination.specialty}></td>
									<td>Registered GP Practice Name</td>
									<td><input type="text" name="referrer.igrDestination.registeredPracticeName" value=${referralCommand.referrer.igrDestination.registeredPracticeName}></td>
								</tr>
								<tr>
									<td>Practice/Clinic Name</td>
									<td><input type="text"  name="referrer.igrDestination.practiceName" value=${referralCommand.referrer.igrDestination.practiceName}></td>
									<td colspan=2></td>
								</tr>
								<tr>
									<td>Referred To</td>
									<td><input type="text"  name="referrer.igrDestination.referredTo" value=${referralCommand.referrer.igrDestination.referredTo}></td>
									<td colspan=2></td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
				<tr>
					<td>Role</td>
					<td><input type="text" name="referrer.role.name"  value=${referralCommand.referrer.role.name}></td>
				</tr>
				<tr>
					<td>Speciality</td>
					<td><input type="text"  name="referrer.speciality"  value=${referralCommand.referrer.speciality}></td>
				</tr>
				<tr>
					<td>Practice/Clinic Name *</td>
					<td><input type="text" name="referrer.practiceName" value=${referralCommand.referrer.practiceName}></td>
				</tr>
				<tr>
					<td>Practice Code</td>
					<td><input type="text" name="referrer.practiceCode" value=${referralCommand.referrer.practiceCode}></td>
				</tr>
				<tr>
					<td>Address Line1</td>
					<td><input type="text" name="referrer.address.line1" value=${referralCommand.referrer.address.line1}></td>
					<td>Address Line2</td>
					<td><input type="text" name="referrer.address.line2" value=${referralCommand.referrer.address.line2}></td>
					<td>Address Line3</td>
					<td><input type="text" name="referrer.address.line3" value=${referralCommand.referrer.address.line3}></td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text"  name="referrer.address.city" value=${referralCommand.referrer.address.city}></td>
					<td>Country</td>
					<td><input type="text"  name="referrer.address.country" value=${referralCommand.referrer.address.county}></td>
					<td>Postcode</td>
					<td><input type="text"  name="referrer.address.postCode" value=${referralCommand.referrer.address.postCode}></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="text"  name="referrer.contactDetails.phone" value=${referralCommand.referrer.contactDetails.phone}></td>
					<td>Fax Number</td>
					<td><input type="text" name="referrer.contactDetails.fax" value=${referralCommand.referrer.contactDetails.fax}></td>
					<td>Mobile Number</td>
					<td><input type="text"  name="referrer.contactDetails.mobile" value=${referralCommand.referrer.contactDetails.mobile}></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text"  name="referrer.contactDetails.email" value=${referralCommand.referrer.contactDetails.email}></td>
					<td colspan=4></td>
				</tr>
			</table>
		</div>
		<br><u>Referral Context</u>
		<div class="inner_patient">
			<table>
				<tr>
					<td>Speciality</td>
					<td><input type="text"   name="specialty" value=${referralCommand.specialty}></td>
					<td>Reason</td>
					<td><input type="text" name="reason" value=${referralCommand.reason}></td>
					<td colspan=2></td>
				</tr>
				<tr>
					<td>Priority</td>
					<td><input type="text" name="priority" value=${referralCommand.priority}></td>
					<td>Provider</td>
					<td><input type="text" name="provider" value=${referralCommand.provider}></td>
					<td colspan=2></td>
				</tr>
				<tr>
					<td>Add Attachment 1</td>
					<td><input type="text" name="attachmentOne" value=${referralCommand.attachmentOne}></td>
					<td>Share-point Link 1</td>
					<td><input type="text" name="sharePointLinkOne" value=${referralCommand.sharePointLinkOne}></td>
					<td colspan=2></td>
				</tr>
				<tr>
					<td>Add Attachment 2</td>
					<td><input type="text"  name="attachmentTwo" value=${referralCommand.attachmentTwo}></td>
					<td>Share-point Link 2</td>
					<td><input type="text" name="sharePointLinkTwo" value=${referralCommand.sharePointLinkTwo}></td>
					<td colspan=2></td>
				</tr>
				<tr>
					<td>Add Attachment 3</td>
					<td><input type="text" name="attachmentThree" value=${referralCommand.attachmentThree}></td>
					<td>Share-point Link 3</td>
					<td><input type="text"  name="sharePointLinkThree" value=${referralCommand.sharePointLinkThree}></td>
					<td colspan=2></td>
				</tr>
			</table>
		</div>
		<br>
		<input type="submit" name="action" value="Submit"/>
		<input type="submit" name="action" value="Validate" />
		<input type="submit" name="action" value="Reject" />
	</form>

</div>
</body>
</html>