$('document').ready(function(){
	$('table #editButton').on('click',function(event){
	event.preventDefault();
	
	var href=$(this).attr('href')//current button attribute
	//to get this url countries/findById/?id=5
	
	$.get(href,function(client,status){
		$('#txtIdEdit').val(client.id);
		$('#txtNameEdit').val(client.name);
		$('#txtDetailsEdit').val(client.details);
		$('#txtWebsiteEdit').val(client.website);
		$('#txtAddressEdit').val(client.address);
		$('#ddlCountryEdit').val(client.countryid);
		$('#ddlStateEdit').val(client.stateid);
		$('#txtCityEdit').val(client.city);
		$('#txtPhoneEdit').val(client.phone);
		$('#txtMobileEdit').val(client.mobile);
		$('#txtEmailEdit').val(client.email);
	})
		$('#editModal').modal();
	});
	
	$('table #deleteButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$('#confirmDeleteButton').attr('href',href);
		$('#deleteModal').modal();
	});
});