function showList(link) {
    const linkText = link.innerText;
    const listAll = document.querySelectorAll('.locationAreaList');

    // 정규표현식 패턴을 생성. '$'는 문자열의 끝을 나타냄.
    const pattern = new RegExp(linkText + '$');

    listAll.forEach(function (item) {
        // 위치 목록의 텍스트 내용을 가져옴.
        const textContent = item.textContent.trim();

        // 정규표현식으로 패턴을 검사.
        if (pattern.test(textContent)) {
            item.style.display = 'flex';
        } else {
            item.style.display = 'none';
        }
    });
}