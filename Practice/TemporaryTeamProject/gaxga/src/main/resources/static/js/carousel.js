let currentIndex = 0;
const categoryItems = document.querySelectorAll('.intro .center .list');
const totalItems = categoryItems.length;

function showCategory(index) {
    categoryItems.forEach(item => {
        item.style.display = 'none';
    });
    categoryItems[index].style.display = 'inline-block';
}

function prevCategory() {
    currentIndex = (currentIndex - 1 + totalItems) % totalItems;
    showCategory(currentIndex);
}

function nextCategory() {
    currentIndex = (currentIndex + 1) % totalItems;
    showCategory(currentIndex);
}

// 페이지 로드 시 첫 번째 카테고리 항목 보이기
showCategory(currentIndex);
