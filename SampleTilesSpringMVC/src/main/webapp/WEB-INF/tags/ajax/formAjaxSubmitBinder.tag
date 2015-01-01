<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="formId" required="true" rtexprvalue="true" description="no need to add a '#'"%>
<%@ attribute name="event_name" required="true" rtexprvalue="true" description="no need to add a '#'"%>
<%@ attribute name="submitUrl" required="true" rtexprvalue="true"%>
<%@ attribute name="callback" rtexprvalue="true"%>
<%@ attribute name="success_callback" rtexprvalue="true"%>
<%@ attribute name="error_callback" rtexprvalue="true"%>
<script type="text/javascript">
	$(document).ready(function() {
		var $form = $('#${formId}');
		$form.bind('${event_name}', function(e) {
			var serialized_data = $form.serialize();
			$.ajax({
				async: true,
				type: $form.attr('method'),
				url: '${submitUrl}',
				data: serialized_data,
				dataType: 'json',
				success: function(rs) {
					if(rs.valErrFlag){
						for (var i = 0; i < rs.valErrMsgList.length; i++) {
							var item = rs.valErrMsgList[i];
							var $controlGroup = $('#' + item.fieldName + 'ControlGroup');
							$controlGroup.addClass('error');
							$controlGroup.find('.help-inline').html(item.message);
						}
						//$("#msg_area").addClass('error');
						//$("#msg_area").html("エラーを修正して、再度登録してください。");
					} else {
						${callback}(rs);
						/*
						$("#msg_area").addClass('success');
						$("#msg_area").html("登録しました。");
						*/
					}
					<% if (success_callback != null) { %>
					${success_callback}(rs);
					<% } %>
					<% if (callback != null) { %>
					${callback}(rs);
					<% } %>
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					/*
					$("#msg_area").addClass('error');
					$("#msg_area").html("Error :" + errorThrown);
					*/
					<% if (error_callback != null) { %>
					${error_callback}(XMLHttpRequest, textStatus, errorThrown);
					<% } %>
					<% if (callback != null) { %>
					${callback}(rs);
					<% } %>
				}
			});
			e.preventDefault();
			return false;
		});
	});
</script>