define(['backbone'], function(Backbone){
  
 App.Models.Application = Backbone.Model.extend({
	 idAttribute: "id",
	 validate: function(attrs, options) {
		 if (attrs.name == '') {
			 swal('Введите название приложения');	
		      return "необходимо ввести имя";
		 }
     },	 	  
 });
 return  App.Models.Application;
});