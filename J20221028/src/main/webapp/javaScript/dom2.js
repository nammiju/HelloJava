// dom2.js

document.addEventListener('DOMContentLoaded', domLoadedFunc);
function domLoadedFunc() {
	let data = `[{"id":1,"first_name":"Halli","last_name":"Gorhardt","email":"hgorhardt0@wp.com","gender":"Female","salary":2563},
				  {"id":2,"first_name":"Faustina","last_name":"Olivet","email":"folivet1@netscape.com","gender":"Female","salary":7847},
				  {"id":3,"first_name":"Molli","last_name":"Woodeson","email":"mwoodeson2@fema.gov","gender":"Female","salary":9947},
				  {"id":4,"first_name":"Izaak","last_name":"Threlfall","email":"ithrelfall3@cargocollective.com","gender":"Male","salary":8243}
				 ]`;
	let obj = {}
	let result = JSON.parse(data); // json형태의 데이터를 자바스크립트의 object로 바꿔줌
	// console.log(result);

	// console.log(result[1].email);
	// for (let i=0; i<result.length; i++){
	// 	console.log(`firstName: ${result[i].first_name}, lastName: ${result[i]['last_name']}`);
	// }
	// // 확장for.
	// for (let obj of result) {
	// 	console.log(`id: ${obj.id}, email: ${obj['email']}`)
	// }
	// console.clear();
	// // 배열일 경우에는 Array.forEach()
	// result.forEach(function(value, index, array) {
	// 	//if (value.salary > 5000 )
	// 	if (index < 2)
	// 		console.log(value, index);
	// }); // 매개값으로 함수를 받음.

	// 확장 for.
	// table.
	let table = document.createElement('table');
	let show = document.getElementById('show');
	show.appendChild(table);
	// thead
	let thead = document.createElement('thead');
	let tr = document.createElement('tr');
	let titles = ['아이디', '이름', '이메일', '성별', '급여', '삭제'];
	for (let title of titles) {
		let thTag = document.createElement('th');
		let thTxt = document.createTextNode(title); // <th>아이디</th>
		thTag.appendChild(thTxt);
		tr.appendChild(thTag);
	}
	// tr에 체크박스 생성.
	let th = document.createElement('th');
	let checkbox = document.createElement('input');
	checkbox.setAttribute('type', 'checkbox');
	checkbox.addEventListener('change', function() {
		let cks = document.querySelectorAll('#show input[type="checkbox"]');
		cks.forEach(function(check) {
			check.checked = checkbox.checked;
		});
	})
	th.appendChild(checkbox);
	tr.appendChild(th);

	thead.appendChild(tr);
	table.appendChild(thead);

	// tbody	
	let tbody = document.createElement('tbody');
	table.appendChild(tbody);
	let fields = ['id', 'first_name', 'email', 'gender', 'salary'];
	for (let obj of result) { // 데이터 건수만큼 반복.
		let tr = makeTr(obj);
		tbody.appendChild(tr);
	} // end of for (let obj of result)

	// 추가버튼에 이벤트 등록.
	document.querySelector('button[type="button"]').addEventListener('click', function() {
		console.log('추가버튼...')
		let id = document.getElementById('id').value;
		let fn = document.getElementById('fname').value;
		let em = document.getElementById('email').value;
		let sa = document.getElementById('salary').value;
		let gn = document.getElementById('gender').value;
		// 필수입력항목 확인.
		let check;
		let newRow = {
			id: id,
			first_name: fn,
			email: em,
			salary: sa,
			gender: gn
		}
		document.querySelector('#show>table>tbody').appendChild(makeTr(newRow));

	});

	// 수정버튼에 이벤트 등록.
	document.querySelectorAll('button[type="button"]')[1].addEventListener('click', updateFunc);

	function updateFunc() {
		let trs = document.querySelectorAll('#show>table>tbody>tr');
		let id = document.getElementById('id').value;
		for (let i = 0; i < trs.length; i++) {
			if (id == trs[i].children[0].textContent) {
				trs[i].children[1].textContent = document.getElementById('fname').value;
				trs[i].children[2].textContent = document.getElementById('email').value;
				trs[i].children[3].textContent = document.getElementById('gender').value;
				trs[i].children[4].textContent = document.getElementById('salary').value;
			}
		}
	}

	// 선택삭제 버튼에 이벤트 등록.
	document.querySelectorAll('button[type="button"]')[2].addEventListener('click', deleteCheckFunc);
	function deleteCheckFunc() {
		let trs = document.querySelectorAll('#show>table>tbody>tr');
		for (let i = 0; i < trs.length; i++) {
			if (trs[i].children[6].children[0].checked == true) {
				trs[i].remove();
			}
		}
	}

	function makeTr(row) {
		// 데이터 건수만큼 반복.
		let tr = document.createElement('tr');
		tr.addEventListener('mouseover', showDetailFunc);
		tr.addEventListener('click', function() {
			document.getElementById('id').value = this.children[0].textContent;
			document.getElementById('fname').value = this.children[1].textContent;
			document.getElementById('email').value = this.children[2].textContent;
			document.getElementById('salary').value = this.children[4].textContent;
			document.getElementById('gender').value = this.children[3].textContent;
		})
		tr.addEventListener('mouseout', function() {
			this.style.backgroundColor = null;
		});
		for (let field of fields) {
			// 항목만큼 반복.
			let td = document.createElement('td');
			let txt = document.createTextNode(row[field]);
			td.appendChild(txt);
			tr.appendChild(td);
		}
		// 삭제버튼. <button>삭제</button>
		let td = document.createElement('td');
		let btn = document.createElement('button');
		btn.addEventListener('click', function() {
			console.log(this); // <button>삭제</button>
			this.parentElement.parentElement.remove(); // 버튼의 부모요소 : tr의 부모요소: td가 삭제됨.
		})
		let txt = document.createTextNode('삭제');
		td.appendChild(btn);
		btn.appendChild(txt);
		tr.appendChild(td);

		// 체크박스.
		td = document.createElement('td');
		td.style.textAlign = 'center';
		let ckeckbox = document.createElement('input');
		ckeckbox.addEventListener('change', function() {
			console.log(this.checked);
		})
		ckeckbox.setAttribute('type', 'checkbox');
		td.appendChild(ckeckbox);
		tr.appendChild(td);

		return tr;
	} // end of makeTr()

	function showDetailFunc() {
		this.style.backgroundColor = 'yellow';
		// console.log(this.children[2].textContent)
	}

} // end of domLoadedFunc()
