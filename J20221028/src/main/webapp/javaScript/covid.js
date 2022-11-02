// covid.js

window.onload = function () {
    // request url.
    let url =
        'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&returnType=json&serviceKey=U8FEpdtnPBi%2BHWUgbsx3rq6Br%2BSlSlG00z%2B4tM%2BH7s37NiRML3q2mJH%2Fgwc2c8BiNZujfGhAG7gtjPcBhLdaZA%3D%3D';

    fetch(url)
        .then(result => result.json()) // json -> object
        .then(showList)
        .catch(error => console.log(error));

    document.querySelector('#findBtn').addEventListener('click', findCenterList); // 찾기 버튼에 이벤트 걸어줌.
}
let titles = {
    id: '센터아이디',
    centerName: '센터명',
    phoneNumber: '연락처',
    lat: '위도',
    lng: '경도'
};
let data; // data를 전역변수로 선언.

function showList(result) {
    // 타이틀 생성부분.
    makeHead();

    // body 영역 생성. // 데이터 초기화.
    console.log(result);
    data = result.data; // 전체 데이터. 위에서 전역변수로 선언한것이 로딩되자마자 젤 먼저 함수가 실행되면서 전체데이터를 담게됨.

    // option 태그 설정.
    makeOption(data);

    let selectedCity = data.filter(center => center.sido == '서울특별시');
    // 페이지가 로딩되면 젤첨은 sido값이 서울특별시인 데이터만 출력됨.

    makeList(selectedCity);
}

function findCenterList() {
    let searchKey = document.querySelector('#city').value;
    let searchAry = data.filter(center => center.sido == searchKey);
    makeList(searchAry);
}

function makeOption(ary = []) {
    // select 태그 생성.
    let sidoAry = [];
    // data에 있는 센터정보와 sidoAry에 있는 센터정보를 비교.
    // sidoAry에 값이 있으면 no, sidoAry에 값이 없으면 추가.(중복값없게 추가한다는 뜻)
    ary.forEach(center => {
        if (sidoAry.indexOf(center.sido) == -1) {
            sidoAry.push(center.sido);
        }
    });
    let cityList = document.getElementById('city');
    sidoAry.forEach(sido => {
        let option = document.createElement('option');
        option.value = sido;
        option.textContent = sido;
        cityList.append(option);

    });
}

function makeList(ary = []) {
    // 화면에 tr이 있으면 tr을 다 삭제하고
    document.querySelectorAll('#list>tr').forEach(tr => tr.remove()); // tr
    // 새로운 tr을 출력해줌.
    let list = document.getElementById('list');
    ary.forEach(center => {
        list.append(makeTr(center));
    });

    // 화면에 뜨는tr에 순번 붙여주기
    document.querySelectorAll('#list>tr').forEach((tr, idx) => {
        let td = document.createElement('td');
        td.textContent = idx + 1;
        tr.prepend(td); // append(): 마지막 위치에 추가. prepend(): 처음 위치에 추가.
    })
}

function makeHead() {
    // 타이틀.
    let tr = document.createElement('tr');
    let th = document.createElement('th');
    th.textContent = '순번';
    tr.appendChild(th);
    for (let title in titles) {
        let th = document.createElement('th');
        let txt = document.createTextNode(titles[title]);
        th.appendChild(txt);
        tr.appendChild(th);
    }
    document.getElementById('tltle').append(tr);
}

function makeTr(row = {}) {
    let tr = document.createElement('tr');
    tr.setAttribute('lng', row.lng); // 해당 tr의 위도 경도값이 tr속성에 담기도록 설정
    tr.setAttribute('lat', row.lat);
    tr.setAttribute('facilityName', row.facilityName);
    tr.addEventListener('click', openInfoWindow); // tr클릭하면 열리도록 함
    // td생성.
    for (let field in titles) {
        let td = document.createElement('td');
        let txt = document.createTextNode(row[field]); //row의 값과 field의 값의 조화
        td.appendChild(txt);
        tr.appendChild(td);
    }
    return tr;
}

function openInfoWindow(e) {
    console.log(e.target.parentElement); // tr의 lng, lat
    let lng = e.target.parentElement.getAttribute('lng');
    let lat = e.target.parentElement.getAttribute('lat');
    let facilityName = e.target.parentElement.getAttribute('facilityName');
    window.location.href = 'infoWindow.html?x=' + lng + '&y=' + lat + '&facilityName=' + facilityName; // 위도, 경도 값을 파라메터로 넘김.
}