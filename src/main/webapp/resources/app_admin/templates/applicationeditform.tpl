      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 class="modal-title"><%= operation%></h4>
      </div>
      
     <div class="modal-body">
       
       <% if (mode !== 'editmode') { %> 	 	
       
	  		<div class="form-group">
				<label class="control-label" for="inputDefault">Название</label>
				<input type="text" class="form-control" id="nameinput"/>
			</div>
			<div class="form-group">
				<label class="control-label" for="inputDefault">Описание</label>
				<input type="text" class="form-control" id="applicationdescriptioninput"/>
			</div>
			
				
	   <%} else {%>         
	   
           <% casheapplications.each(function(application) {%>
			
			<div class="form-group">
				<label class="control-label" for="inputDefault">Название</label>
				<input type="text" class="form-control" id="nameinput<%=application.get('id')%>" value="<%= application.get('name')%>"/>
			</div>
			<div class="form-group">
				<label class="control-label" for="inputDefault">Описание</label>
				<input type="text" class="form-control" id="applicationdescriptioninput<%=application.get('id')%>" value="<%= application.get('description') %>"/>
			</div>
			
			<% });%>
          <%}%> 
			
      </div>      
      
      <!-- Футер модального окна -->
      <div class="modal-footer">
        <% if (mode !== 'editmode') { %>
           <button type="button" id="addbtn" class="btn btn-default" data-dismiss="modal">Сохранить</button>        
         <%} else {%>   
           <button type="button" id="updbtn" class="btn btn-default" data-dismiss="modal">Сохранить</button>
         <%}%>  
        <button type="button" class="btn btn-default" data-dismiss="modal">Отменить</button>             
      </div>
 