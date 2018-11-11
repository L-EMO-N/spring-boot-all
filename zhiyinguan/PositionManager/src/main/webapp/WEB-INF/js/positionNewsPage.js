function load(ts){
	ts.style.display = 'block';
}
function error(ts){
	style='display:none'
}
function toNewsDetails(a,newsId){
	a.style.color='#808080';
	window.location.href="../getNewsDetails/"+newsId; 
}