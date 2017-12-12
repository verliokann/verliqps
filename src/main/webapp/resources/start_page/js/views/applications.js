define(['backgrid'], 
		function(Backgrid){
	
//******************************************************************************************************************************
//     (начало) Описание представления, формирующего модальное окно с данными сущности "Роли"
//******************************************************************************************************************************
	
	App.Views.applicationsView = Backbone.View.extend({
		tagName: 'div',
		className: '.application',					
		/* ********************************** Инициализация********************************************** */
		initialize: function(options){	
			this.collection = options.collection; 
			var _thisView = this; 
			app.content='gh'; //используем для хранения склеенных справочных данных (списка групп пользователей)
			this.container = options.container; 
			
			this.collection.fetch({				
				 reset: true,
				 success: function () {							
					 _thisView.collection.each(function (model) {
						_thisView.render(model);	
					});
					
					$(_thisView.container).append(_thisView.el);
				}
			})		
			
		 },			 		
		 /*********************************** Рендер ******************************************* */		 
		 render: function(model){	
			 $('#container').append(
			  '<div class="col-md-'+$('#col-number').val()+'">'
			      + '<a class="btn btn-primary" href="'+model.get('path')+'">Открыть</a>'
			      + '<h3 class="text-center">'+model.get('name')+'</h3>'
			      + '<p>'+model.get('description')+'</p>'
			   + '</div>');

		    return this;
		 }
	});
//******************************************************************************************************************************
//   (конец)    Описание представления, формирующего модальное окно с данными сущности "Роли"
//	
//****************************************************************************************************************************** 
 return App.Views.applicationsView;
});