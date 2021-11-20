$('document').ready(function(){
	
		$('table #editButton').on('click',function(event){
				event.preventDefault();
				var href=$(this).attr('href');
		$.get(href,function(state,status){
			$('#idEdit').val(state.id);
			$('#ddlCountryEdit').val(state.countryid);
			$('#capitalEdit').val(state.capital);
			$('#codeEdit').val(state.code);
			$('#nameEdit').val(state.name);
			$('#detailsEdit').val(state.details);
		});
		$('#editModal').modal();
	});
	
	
	
$('table #deleteButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$('#confirmDeleteButton').attr('href',href);
		$('#deleteModal').modal();
	});
	
	
	
	$('table #detailsButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		alert(href);
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