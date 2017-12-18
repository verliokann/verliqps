define(['backbone', 'applicationpaggrid', 'applications', 'application', 'text!app_admin/templates/applicationeditform.tpl'], 
		function(BackBone, ApplicationPagGrid,  Applications, Application, REF){
	
	ZUI.loadCss('http://localhost:8080/cmf/resources/components/backgrid-0.3.7/lib/backgrid.css');
	ZUI.loadCss('http://localhost:8080/cmf/resources/components/backgrid-paginator-master/backgrid-paginator.css');
	ZUI.loadCss('http://localhost:8080/cmf/resources/components/backgrid-filter-master/backgrid-filter.css');
	ZUI.loadCss('http://localhost:8080/cmf/resources/app_admin/style/css/simplereferencegrid.css');
	ZUI.loadCss('http://localhost:8080/cmf/resources/components/backgrid-select-all-master/backgrid-select-all.min.css');

	App.Views.ApplicationEditForm = Backbone.View.extend({
	        
		    template: _.template(REF),

		    events: {		    	
		      	'click #addbtn': 'addClicked',	        	
	        	'click #updbtn': 'updClicked'
	    	},

	        initialize: function() {	        	
	        	this.generateEditForm();
		    },		 
		    render: function() {		    	
		        this.$el.html(this.template({operation: app.operation, casheapplications : app.casheedtrecords, mode: app.mode}));
		        return this;
		    },
	    	addClicked: function () {	    	
		    	var newapplication = app.applications.create(
		    			         {
		    			        	 name: this.$el.find('input[id="nameinput"]').val().trim(),		    			         
  		                             description: this.$el.find('input[id="applicationdescriptioninput"]').val()
  		                        },
  		                        {
  		                              wait: true,  		                        
  		                        	  success: function (model, response) {  		                        
  		                        		   			console.log("Идентифиатор новой роли ", response);
  		                        		   			
  		                        	   			},
  		                        	  error: function (model, err) {
  		          			                console.log("Роль не добавилась ", err);
  		          			          } 			
  					            }		    	
		    	);	    	
		    },
		    updClicked: function () {	    	
		    	for (i=(app.casheedtrecords.length-1);i>-1;i--){
		    	    console.log("Обновляем модель с индексом "+i);
		    	    
		    	    app.casheedtrecords.at(i).set({name: this.$el.find('input[id="nameinput'+app.casheedtrecords.at(i).get("id")+'"]').val().trim(),
		                 description: this.$el.find('input[id="applicationdescriptioninput'+app.casheedtrecords.at(i).get("id")+'"]').val()
		            }, {validate:true});   
		    	    app.casheedtrecords.at(i).save({}, {
			            success: function (model, respose, options) {
			                console.log("Роль шикарно обновилась");			                
			                app.applications.sort();   //привязать к методам applicationpaggrid		 	               
			                app.mpg.render();
			                app.casheedtrecords.reset(); //сбрасываем кэш (на него реагируют CUD кнопки )
			            },
			            error: function (model, xhr, options) {
			                console.log("Роль не обновилась");
			            }
			        });
		    	};  
		    },		    
		    generateEditForm:function(){
		    	//Удаляем предыдущую форму
		    	$('div[id="editform"] div[id="applicationedtform"]').empty();
		    	//Рендерим и добавляем в модальное окно см. app_admin.jsp
		    	$('div[id="editform"] div[id="applicationedtform"]').append(this.render().el);
		    	console.log('Шаблон ', this.el);
		    },
		    
	 });
	 
	 return App.Views.ApplicationEditForm;
});











