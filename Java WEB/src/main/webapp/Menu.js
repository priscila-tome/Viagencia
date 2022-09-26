let mostrar = true; 

const menuSection = document.querySelector(".menu-section")
const menuToggle = menuSection.querySelector(".menu-toggle")

menuToggle.addEventListener("click", () => {

    document.body.style.overflow = mostrar ? "hidden" : "initial"

    menuSection.classList.toggle("on", mostrar)
    mostrar = !mostrar;
})