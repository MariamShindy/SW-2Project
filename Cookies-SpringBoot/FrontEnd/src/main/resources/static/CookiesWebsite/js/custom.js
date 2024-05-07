// to get current year
function getYear() {
    var currentDate = new Date();
    var currentYear = currentDate.getFullYear();
    document.querySelector("#displayYear").innerHTML = currentYear;
}

getYear();

// owl carousel 

$('.owl-carousel').owlCarousel({
    loop: true,
    margin: 10,
    nav: true,
    autoplay: true,
    autoplayHoverPause: true,
    responsive: {
        0: {
            items: 1
        },
        600: {
            items: 3
        },
        1000: {
            items: 6
        }
    }
})

function showMoreCards() {
  const additionalCards = document.querySelectorAll('.card4, .card5, .card6');
  additionalCards.forEach(card => card.classList.toggle('hidden'));
}
function addToWishlist(element) {
alert('Product added to wishlist!');
}
function changeText(element, newText) {
              if (!element.originalText) {
                  element.originalText = element.textContent;
              }
                element.innerHTML= newText;
}
function changeImage(element, newImage) {
            if (!element.originalImage) {
                element.originalImage = element.src;
            }
            element.src = newImage;
}

