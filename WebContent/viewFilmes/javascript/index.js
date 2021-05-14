const sliders = document.querySelector(".carouselbox");
const sliders2 = document.getElementById("teste1");
const sliders3 = document.getElementById("teste2");
var scrollPerClick;
var ImagePadding = 20;



// Scroll Functionality
var scrollAmount = 0;

function sliderScrollLeft() {
    console.log(scrollPerClick)

  sliders.scrollTo({
    top: 0,
    left: (scrollAmount -= scrollPerClick),
    behavior: "smooth",
  });

  if (scrollAmount < 0) {
    scrollAmount = 0;
  }

}

function sliderScrollRight() {
  if (scrollAmount <= sliders.scrollWidth - sliders.clientWidth) {
    sliders.scrollTo({
      top: 0,
      left: (scrollAmount += scrollPerClick),
      behavior: "smooth",
    });

  }
}
function sliderScrollLeft2() {
    console.log(scrollPerClick)

  sliders2.scrollTo({
    top: 0,
    left: (scrollAmount -= scrollPerClick),
    behavior: "smooth",
  });

  if (scrollAmount < 0) {
    scrollAmount = 0;
  }

}

function sliderScrollRight2() {
  if (scrollAmount <= sliders2.scrollWidth - sliders2.clientWidth) {
    sliders2.scrollTo({
      top: 0,
      left: (scrollAmount += scrollPerClick),
      behavior: "smooth",
    });

  }
}
function sliderScrollLeft3() {
    console.log(scrollPerClick)

  sliders3.scrollTo({
    top: 0,
    left: (scrollAmount -= scrollPerClick),
    behavior: "smooth",
  });

  if (scrollAmount < 0) {
    scrollAmount = 0;
  }

}

function sliderScrollRight3() {
  if (scrollAmount <= sliders3.scrollWidth - sliders3.clientWidth) {
    sliders3.scrollTo({
      top: 0,
      left: (scrollAmount += scrollPerClick),
      behavior: "smooth",
    });

  }
}
scrollPerClick = 600;