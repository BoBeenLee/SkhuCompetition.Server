<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="confirmpw">
	<form class="form-horizontal" action="${ boardType }/article/read.do" method="post"
		role="form">
		<div class="form-group">
			<label for="inputPassword" class="col-md-3 control-label">Password</label>
			<div class="col-md-6">
				<input type="password" name="password" class="form-control"
					id="inputPassword" placeholder="Password">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-3 col-md-9">
				<button type="submit" class="btn btn-default">확인</button>
			</div>
		</div>
		<input type="hidden" name="ai" value="${ articleId }" />
		<input type="hidden" name="pg" value="${ pagination.currentPage }" />
		<input type="hidden" name="bid" value="${ pagination.bid }" />
		<input type="hidden" name="sz" value="${ pagination.sz }" />
		<input type="hidden" name="is" value="${ pagination.is }" />
	</form>
</div>