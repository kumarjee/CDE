<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript" src="CollapsibleLists.js"></script>
<script>
collapsibleListObj.onload=function(){
	CollapsibleLists.apply();
	};
</script>
<ul style="list-style:none;line-height:28px;" class="collapsibleList" id="collapsibleListObj">
	<li> <a	href="addCertification.html"><b>Home</b></a> </li>
	<li>
    <b>Manage Certifications</b>
    <ul>	
	<li> <a href="addCertification.html">Add Certification</a> </li>
	<li> <a href="uploadquestion.html">Upload Questions</a> </li>
	<li> <a href="questionlist.html">Question list</a> </li>
	<li> <a href="addquestion.html">Add Question</a> </li>
	</ul>
	</li>
	<li>
    <b>Trainings</b>
    <ul>
	<li> Add Course</li>
	<li> View Courses</li>
	<li> Disable</li>
	</ul>
	</li>
	<li>
    <b>Online Quiz</b>
    </li>

</ul>