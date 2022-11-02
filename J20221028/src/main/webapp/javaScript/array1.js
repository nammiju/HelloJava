// array1.js
fetch('data/MOCK_DATA.json')
    .then(result => result.json()) // 결과값 result를 json 메소드로 오브젝트 타입으로 변형?
    .then(composeFnc)
    .catch(error => console.log(error));

function composeFnc(result = []) {
    // 급여 5000넘는 사람들만 filter한 후에 새로운 모임을 생성하기.
    result.filter(row => row.salary > 5000)
        .map(row => {
            let team = { // 오브젝트
                t_id: row.id, // 담는 방식1
                t_name: row.first_name + '/' + row.last_name
            }
            team.t_mail = row.email; // 담는 방식2
            team['t_dept'] = 'Account'; //담는 방식3
            return team;
        })
        .forEach(team => console.log(team));
}

// Array.map() => A라는 데이터를 받아서 새로운 형태의 데이터(A')를 만들어줌 
function mappingFnc(result = []) {
    let newAry = result.map(row => {
        let newObj = {}; // new Object(); 로 새로운 오브젝트 설정?만드러도 댐
        newObj.user_id = row.id;
        newObj.user_name = row.first_name + '-' + row.last_name;
        newObj.info = row.email;

        return newObj;
    });

    newAry.forEach(obj => console.log(obj));
}

function filterFnc(result = []) { // 값이 없으면 빈배열을 선언하겠다
    // Array.filter(): 조건에 맞는 것만 따로 oddAry라는 새로운 배열을 만들어 반환해줌.
    result.filter((row) => row.salary > 5000)
        .forEach(row => console.log(row));

    // oddAry.forEach(row => console.log(row));
}

function showMain(result) {
    console.log(result); // 출력해보니 결과가 배열임
    // Array.forEach() : 반환값없이 최종처리하는 기능을 구현. 
    // forEach: row라는 변수를 받아서 result(배열)의 갯수만큼 함수를 반복해줌
    result.forEach((row, idx) => {
        // if (row.gender == 'Female') {
        if (idx % 2 == 0) {
            console.log(row.id, row.first_name, row.last_name);
        }
    });
}

function sum(a = 0, b = 0) {
    // if(a){
    //     return a+0;
    // }
    // if(b) {
    //     return 0+b;
    // }
    return a + b;
}