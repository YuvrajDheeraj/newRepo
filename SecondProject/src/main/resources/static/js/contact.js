$('document').ready(function(){
	$('table #editButton').on('click',function(event){
	event.preventDefault();
	var href=$(this).attr('href');
	$.get(href,function(contact,status){
		$('#txtIdEdit').val(contact.id);
		$('#txtFirstnameEdit').val(contact.firstname);
		$('#txtLastnameEdit').val(contact.lastname);
		$('#txtEmailEdit').val(contact.phone);
		$('#txtMobileEdit').val(contact.email);
		$('#txtPhoneEdit').val(contact.mobile);
		$('#txtRemarksEdit').val(contact.remarks);
		
	})
		$('#editModal').modal();
	});
	
	
	$('table #deleteButton').on('click',function(event){
		event.preventDefault();
		/*var href=$(this).attr('href');
		$('#confirmDeleteButton').attr('href',href);*/
		$('#deleteModal').modal();
	});
	
	
	$('table #detailsButton').on('click',function(event){
 			event.preventDefault();
 			var href=$(this).attr('href');
 			$.get(href,function(contact,status){
			$('#idDetails').val(contact.id);
		$('#nameDetails').val(contact.firstname.concat(' ',contact.lastname));
		$('#detailsDetails').val(contact.remarks);
		
		$('#lastModifiedByDetails').val('Dheeraj');
		
		let today = new Date().toLocaleDateString()
		$('#lastModifiedDateDetails').val(today);
		
			});		
 			$('#detailsModal').modal();
 			});
});