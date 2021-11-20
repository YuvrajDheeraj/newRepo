$('document').ready(function(){
		$('table #editButton').on('click',function(event){
			event.preventDefault();
			var href=$(this).attr('href');
			$.get(href, function(employee, status){
			$('#txtAddressEdit').val(employee.address);
			$('#txtCityEdit').val(employee.city);
			$('#ddlNationalityEdit').val(employee.countryid);			
			var dob = employee.dateOfBirth.substr(0,10);
			$('#txtDateOfBirthEdit').val(dob);
			$('#txtEmailEdit').val(employee.email);
			$('#txtFirstnameEdit').val(employee.firstname);
			$('#ddlGenderEdit').val(employee.gender);
			$('#txtIdEdit').val(employee.id);
			$('#txtInitialsEdit').val(employee.initials);
			$('#txtLastnameEdit').val(employee.lastname);
			$('#ddlMaritalStatusEdit').val(employee.maritalStatus);
			$('#txtMobileEdit').val(employee.mobile);
			$('#txtOthernameEdit').val(employee.othername);		
			$('#txtPhoneEdit').val(employee.phone);			
			$('#fupPhotoEdit').val(employee.photo);			
			$('#txtSSNEdit').val(employee.socialSecurityNumber);			
			$('#ddlStateEdit').val(employee.stateid);	
			$('#ddlTitleEdit').val(employee.title);			
			$('#ddlEmployeeTypeEdit').val(employee.employeetypeid);				
			var hireDate = employee.hireDate.substr(0,10);
			$('#txtHireDateEdit').val(hireDate);
			$('#ddlJobTitleEdit').val(employee.jobtitleid);
		});
		$('#editModal').modal();
	});
	
	
	
$('table #deleteButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$('#confirmDeleteButton').attr('href',href);
		$('#deleteModal').modal();
	});
	
		/*To display image in modal*/
	
				$('.table #photoButton').on('click',function(event) {
			   event.preventDefault();
			   var href = $(this).attr('href');
			   $('#photoModal #employeePhoto').attr('src', href);
			   $('#photoModal').modal();		
			});	
		/* end To display image in modal*/
	
	$('table #detailsButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(state,status){
			$('#idDetails').val(state.id);
			$('#ddlCountryDetails').val(state.countryid);
			$('#capitalDetails').val(state.capital);
			$('#codeEdit').val(state.code);
			$('#nameDetails').val(state.name);
			$('#detailsDetails').val(state.details);
			
		});
		$('#detailsModal').modal();
	});
	
});





/*	angular.module("myApp",[])
	.controller("myCtrl",function($scope, $http, $log){
	init();
	$scope.list=null;
	function init(){
		$http.get("state").then(function(response){
			$scope.list=response.data;
			alert(response.data);
		});
	}
	});*/