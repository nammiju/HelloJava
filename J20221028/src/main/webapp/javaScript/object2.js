/**
 * object2.js
 */

document.addEventListener('DOMContentLoaded', function(){
 	//	document.getElementById('show').innerHTML = '<p>Hello.world</p>'
	let data = `[{"id":1,"first_name":"Halli","last_name":"Gorhardt","email":"hgorhardt0@wp.com","gender":"Female","salary":2563},
{"id":2,"first_name":"Faustina","last_name":"Olivet","email":"folivet1@netscape.com","gender":"Female","salary":7847},
{"id":3,"first_name":"Molli","last_name":"Woodeson","email":"mwoodeson2@fema.gov","gender":"Female","salary":9947},
{"id":4,"first_name":"Izaak","last_name":"Threlfall","email":"ithrelfall3@cargocollective.com","gender":"Male","salary":8243},
{"id":5,"first_name":"Marcie","last_name":"Georgelin","email":"mgeorgelin4@tripod.com","gender":"Polygender","salary":4368},
{"id":6,"first_name":"Reinold","last_name":"Wimpress","email":"rwimpress5@creativecommons.org","gender":"Male","salary":1375},
{"id":7,"first_name":"Rozamond","last_name":"Ivankovic","email":"rivankovic6@wikipedia.org","gender":"Female","salary":9592},
{"id":8,"first_name":"Jacobo","last_name":"Inglis","email":"jinglis7@noaa.gov","gender":"Male","salary":1982},
{"id":9,"first_name":"Miran","last_name":"Redgrove","email":"mredgrove8@marriott.com","gender":"Genderfluid","salary":6746},
{"id":10,"first_name":"Georgena","last_name":"Rowledge","email":"growledge9@chron.com","gender":"Female","salary":4000}]`;

// json 타입 => javascript 오브젝트.

let result = JSON.parse(data);
console.log(result);

// for (String str : personList) {}
// <ul><li>obj</li></ul>...<ul><li>obj</li></ul>
// <div id="show"></div>

const fields = ['id', 'first_name', 'email', 'salary'];
let ulTag = document.createElement('ul');
let trTag = document.createElement('td');
for (row of result) {
	ulTag.appendChild(makeTr(row));
}

document.getElementById('show').appendChild(tTag);

function makeTr(obj) {
	let tdTag = document.createElement('td');
	let str = '';
	for(table of fields) {
		str += `${table}: $obj{table}`;
	}
	let txt = document.createTextNode(str);
	tdTag.appendChild(txt);
	
	return tdTag;
}

function makeList(obj) {
	let liTag = document.createElement('li');
	let str = '';
	for(field of fields) {
		str += `${field}: ${obj[field]} `;
	}
	let txt = document.createTextNode(str);
	liTag.appendChild(txt);
	
	return liTag;
}

});
