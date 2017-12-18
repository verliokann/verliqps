var ZUI ={
		modalToBack: function(fadeclassname, modalid)
		{
			block = document.getElementsByClassName(fadeclassname);
			block[0].id="firstlevelfade";
			block = document.getElementById(modalid);
			block.className="modal firstlevelmodal";    
		},

		modalToFront: function(fadeflvlmodalid, modalflvlid)
		{
			block = document.getElementById(fadeflvlmodalid);
			block.id=""; 
			block = document.getElementById(modalflvlid);
			block.className="modal";       
		},
		
		//Открывает контентную часть модельных форм ввода/редактирования данных
		//Стиль unvisibleblock описан в файле /resources/app_admin/css/admin_main.css
		refreshModal: function(item)
		{
			var item = $(item),
				blockName = item.attr('block');
			
			$("#" + blockName + 'edtform').attr('class', 'modal-content');
			$("#" + blockName + 'deleteform').attr('class', 'modal-content');
			
			$('[block]').each(function(i, elem) {
				var thisObj = $(elem);
				if (blockName == thisObj.attr('block')) return;
				$("#" + thisObj.attr('block') + "edtform").attr('class', 'modal-content unvisibleblock');
				$("#" + thisObj.attr('block') + "deleteform").attr('class', 'modal-content unvisibleblock');
			});
		}, 
		
		loadCss: function (url) {
		    var link = document.createElement("link");
		    link.type = "text/css";
		    link.rel = "stylesheet";
		    link.href = url;
		    document.getElementsByTagName("head")[0].appendChild(link);
		}
		
		
}

