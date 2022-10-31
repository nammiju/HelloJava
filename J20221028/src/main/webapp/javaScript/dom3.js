// dom3.js

document.addEventListener('DOMContentLoaded', function(){
	
	document.querySelector('button').addEventListener('click', function(){
		//아이디 조회해서 화면에서 삭제
		let data = document.querySelectorAll('table>tbody>tr');
		let id = document.getElementById('id').value;
		for (let i = 0; i < data.length; i++) {
			if(id == data[i].children[0].textContent) {
				data[i].remove();
			}
		}
	})
	
	let tableObject = {
		id: 'hong',
		titles: ["아이디", "이름", "이메일", "삭제"],
		data: [{id: 'user1', name: '홍길동', email: 'hong@email'},
			   {id: 'user2', name: '김민서', email: 'kim@email'},
			   {id: 'user3', name: '박항서', email: 'park@email'}],
		addData: function(row){
			this.data.push(row);
		},
		makeTable: function(){
			let table = document.createElement('table');
			let thead = this.makeHead();
			let tbody = this.makeBody();
			table.append(thead, tbody);
			return table;
		},
		makeHead: function() {
			let thead = document.createElement('thead');
			let tr = document.createElement('tr');
			this.titles.forEach(function(title) {
				let th = document.createElement('th');
				let txt = document.createTextNode(title);
				th.append(txt);
				tr.append(th);
				thead.append(tr);
			})
			return thead;
		},
		makeBody: function(){
			let tbody = document.createElement('tbody');
			this.data.forEach(val => {
				let tr = document.createElement('tr');
				tbody.append(tr);
				for (let field in val) { // for in: 오브젝트의 갯수만큼 ??
					let td = document.createElement('td');
					let txt = document.createTextNode(val[field]);
					td.append(txt);
					tr.append(td);
				}
				
				// 삭제버튼. 클릭하면 한건 삭제.
				let td = document.createElement('td');
				let btn =  document.createElement('button');
				btn.addEventListener('click', function() {
					this.parentElement.parentElement.remove(); // 버튼의 부모요소 : tr의 부모요소: td가 삭제됨.
				})
				let txt = document.createTextNode('삭제');
				td.appendChild(btn);
				btn.appendChild(txt);
				tr.appendChild(td);
			});
			return tbody;
		},
		init: function(){
			document.getElementsByTagName('body')[0].append(this.makeTable());
		}
	}
	// 데이터 추가.
	tableObject.addData({id: 'user4', name: '황선홍', email: 'hwang@email'});
	
	tableObject.init();

}) // end of DOMContentLoaded.

