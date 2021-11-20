$('document').ready(function(){
	$('table #editButton').on('click',function(event){
	event.preventDefault();
	var href=$(this).attr('href')//current button attribute
	//to get this url countries/findById/?id=5
	
	$.get(href,function(supplier,status){
		$('#txtIdEdit').val(supplier.id);
		$('#txtNameEdit').val(supplier.name);
		$('#txtDetailsEdit').val(supplier.details);
		$('#txtWebsiteEdit').val(supplier.website);
		$('#txtAddressEdit').val(supplier.address);
		$('#ddlCountryEdit').val(supplier.countryid);
		$('#ddlStateEdit').val(supplier.stateid);
		$('#txtCityEdit').val(supplier.city);
		$('#txtPhoneEdit').val(supplier.phone);
		$('#txtMobileEdit').val(supplier.mobile);
		$('#txtEmailEdit').val(supplier.email);
	})
		$('#editModal').modal();
	});
	
	$('table #deleteButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		alert(href);
		$('#confirmDeleteButton').attr('href',href);
		$('#deleteModal').modal();
	});
	
	
	$('table #detailsButton').on('click',function(event){
 			event.preventDefault();
 			var href=$(this).attr('href');
 			$.get(href,function(supplier,status){
			$('#idDetails').val(supplier.id);
		$('#ddlCountryDetails').val(supplier.countryid);
		$('#nameDetails').val(supplier.name);
		$('#detailsDetails').val(supplier.details);
		$('#lastModifiedByDetails').val('Dheeraj');
		let today = new Date().toLocaleDateString()
		$('#lastModifiedDateDetails').val(today);
		
			
			
			
			});		
 			$('#detailsModal').modal();
 			});
});