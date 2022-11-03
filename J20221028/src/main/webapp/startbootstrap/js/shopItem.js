// shopItem.js

fetch('../ShopItemListServlet')
    .then(result => result.json())
    .then(itemListShow)
    .catch(err => console.error(err));

function itemListShow(result) {
    console.log(result);
    result.forEach(item => {
        makeItemDiv(item);
    });

}

function makeItemDiv(item = {}) {
    let template = document.querySelector('#template>div');
    let good = template.cloneNode(true);
    good.querySelector('h5').textContent = item.itemName;
    good.querySelector('img.card-img-top').src = '../images/' + item.image;
    good.querySelector('span.text-muted').textContent = item.originPrice;
    good.querySelector('span.text-muted').nextSibling.textContent = " " + item.salePrice;

    // 별점
    let review = item.likeIt; // ex) 4.5 라면 꽉찬별4개 반쪽별1개를 계산해야함
    let a = Math.floor(review); // 꽉찬별만 추출
    let b = review - a; // 반쪽별이 있을때 반쪽별 0.5가 나오고 없으면 0 출력
    let c = Math.floor(5-a-b);
    for (let i = 0; i < a; i++) {
        let div = document.createElement('div');
        div.className = 'bi-star-fill';
        // div.setAttribute('div.d-flex').append(div);
        good.querySelector('div.d-flex').append(div);
    }
    if (b) {
        let div = document.createElement('div');
        div.className = 'bi-star-half';
        good.querySelector('div.d-flex').append(div);
    }
    /// 잘 계산해서 수정하기
    if (review < 4.5) {
        for (let i = 0; i < c; i++) {
            let div = document.createElement('div');
            div.className = 'bi-star';
            good.querySelector('div.d-flex').append(div);
        }
    }
    good.querySelector('a.btn').addEventListener('click', addCartFnc);
    function addCartFnc () {
        let num = document.querySelector('span.badge').textContent;
        num++;
        document.querySelector('span.badge').textContent = num;
    }
    



    // 상품목록
    let parent = document.querySelector('section.py-5>div>div');
    parent.append(good);
    console.log(good);
}