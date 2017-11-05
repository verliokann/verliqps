     <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 class="modal-title">Удаление записей </h4>
      </div>
      <div class="modal-body">
        <div class="form-group">        
        	<% casheapplications.each(function(application) {%>
        	 <div>
  	    	  <label class="label label-warning" for="inputDefault"><%= application.get('id') %></label>	
  	    	  <label class="label label-warning" for="inputDefault"><%= application.get('name')%></label>
  	    	  <label class="label label-warning" for="inputDefault"><%= application.get('description') %></label>
  	    	 <div> 
  	    	<%});%>				
		</div>		
      <div class="modal-footer">
        <button type="button" id="delbtn"  class="btn btn-default" data-dismiss="modal">Удалить</button>
        <button type="button" id="cslbtn" class="btn btn-default" data-dismiss="modal">Отменить</button>        
      </div>
    </div>
  