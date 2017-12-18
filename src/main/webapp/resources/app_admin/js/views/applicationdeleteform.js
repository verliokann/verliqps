define(['backbone', 'applicationpaggrid', 'applications', 'application', 'text!app_admin/templates/applicationdeleteform.tpl'], 
		function(BackBone, ApplicationPagGrid,  Applications, Application, RDLF){
	
	ZUI.loadCss('http://localhost:8080/cmf/resources/components/backgrid-0.3.7/lib/backgrid.css');
	ZUI.loadCss('http://localhost:8080/cmf/resources/components/backgrid-paginator-master/backgrid-paginator.css');
	ZUI.loadCss('http://localhost:8080/cmf/resources/components/backgrid-filter-master/backgrid-filter.css');
	ZUI.loadCss('http://localhost:8080/cmf/resources/app_admin/style/css/simplereferencegrid.css');
	ZUI.loadCss('http://localhost:8080/cmf/resources/components/backgrid-select-all-master/backgrid-select-all.min.css');

	App.Views.ApplicationDeleteForm = Backbone.View.extend({
	        className: "modal-content",
		    template: _.template(RDLF),

		    events: {		    	
		      	'click #delbtn': 'delClicked'              
	    	},

	        initialize: function() {        	
	        	this.generateDeleteForm();
		    },		 
		    render: function() {		    	
		        this.$el.html(this.template({casheapplications : app.casheedtrecords}));
		        return this;
		    },	    	
		    delClicked: function () {
		    	for (i=(app.casheedtrecords.length-1);i>-1;i--){
		    	    console.log("Удаляем модель с индексом "+i);
		    	    app.casheedtrecords.at(i).destroy({	    	      
					    success: function (model, respose, options) {
					        console.log("Приложение удалено");
					    },	    				   	    				   
				    })	 
		    	} 	    	  
		    },		    
		    generateDeleteForm:function(){
		    	//Удаляем предыдущую форму
		    	$('div[id="deleteform"] div[id="applicationdeleteform"]').empty();
		    	//Рендерим и добавляем в модальное окно см. app_admin.jsp
		    	$('div[id="deleteform"] div[id="applicationdeleteform"]').append(this.render().el);		    	
		    }
		  
	 });
	 
	 return App.Views.ApplicationDeleteForm;
});
