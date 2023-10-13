<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="styles.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>

    <!-- Hero Start -->

    <canvas id="c"></canvas>

    <section class="hero" id="pocetna" style="min-height:100vh;">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="swiper-container hero-slider text-center">
                        <div class="swiper-wrapper d-flex justify-content-center">
                            <div class=" slide-content d-flex align-items-center">
                                <div class="single-slide">


                                    <h1 class="underlined mb-3 text-uppercase" data-aos-duration="2000" data-aos="fade-in"
                                        data-aos-delay="1000">Da li možeš da osvojiš RAF?

                                    </h1>
                                    <h2 data-aos-duration="2000" data-aos="fade-in"
                                        data-aos-delay="1200" class="sub-heading mb-3">RAF Hakaton, 21. Decembar.</h2>

                                    <button type="button1" class="button1"  data-aos-duration="2000" data-aos="fade-in"
                                            data-aos-delay="1000" onclick="location.href= 'formaTim.jsp' ">PRIJAVI SE</button>


                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Add Control -->
    <!-- <span class="arr-left"><i class="fa fa-angle-left"></i></span>
    <span class="arr-right"><i class="fa fa-angle-right"></i></span> -->

    <div class="texture"></div>
    <div class="diag-bg"></div>

    <!-- Hero End -->

    <!-- Services Start -->
    <section class="services" id="oTakmicenju">
        <div class="container">
            <div class="title text-center">
                <h6>Ukratko</h6>
                <h1 class="title-blue">O takmičenju</h1>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-lg-4">
                        <div class="media" data-aos="fade-up" data-aos-delay="200" data-aos-duration="400">
                            <img class="mr-4" src="https://hakaton.raf.edu.rs/assets/images/icons/calendar.png" alt="Vreme">
                            <div class="media-body">
                                <h5>Vreme</h5>
                                Takmičenje će početi u subotu, 21. decembra, o tačnoj
                                satnici takmičari će biti naknadno obavešteni.
                                Hakaton traje 24 sata od trenutka prezentovanja teme.
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-4">
                        <div class="media" data-aos="fade-up" data-aos-delay="400" data-aos-duration="600">
                            <img class="mr-4" src="https://hakaton.raf.edu.rs/assets/images/icons/lokacija.png" alt="Mesto">
                            <div class="media-body">
                                <h5>Mesto</h5>
                                Hakaton će se održati na Računarskom fakultetetu. Fakultet se nalazi u samom
                                centru Beograda, u Knez Mihailovoj 6/VI. Svakom timu će biti dodeljena posebna učionica za rad.
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-4">
                        <div class="media" data-aos="fade-up" data-aos-delay="600" data-aos-duration="800">
                            <img class="mr-4" src="https://hakaton.raf.edu.rs/assets/images/icons/idea.png" alt="Tema">
                            <div class="media-body">
                                <h5>Tema</h5>
                                Tema će biti poznata na dan takmičenja. Tada će timovi dobiti sve neophodne informacije
                                i biće upoznati sa zadatkom. Tačno 12 sati nakon početka, svim takmičarima biće predstavljen
                                još jedan zahtev koji bi trebalo da ispune.
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-4">
                        <div class="media" data-aos="fade-up" data-aos-delay="200" data-aos-duration="400">
                            <img class="mr-4" src="https://hakaton.raf.edu.rs/assets/images/icons/ucesce.png" alt="Učešće">
                            <div class="media-body">
                                <h5>Učešće</h5>
                                Takmičenje je otvorenog tipa, a pravo na učešće imaju svi od 18 do 27 godina.
                                Na hakatonu će učestvovati najboljih 8 timova sa 3 do 4 člana.
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-4">
                        <div class="media" data-aos="fade-up" data-aos-delay="400" data-aos-duration="600">
                            <img class="mr-4" src="https://hakaton.raf.edu.rs/assets/images/icons/ocenjivanje.png" alt="Ocenjivanje">
                            <div class="media-body">
                                <h5>Ocenjivanje</h5>
                                Rešenja će biti ocenjena od strane stručnog žirija u više različitih kategorija.
                                Sa tačnim načinom ocenjivanja takmičari će biti upoznati pred početak takmičenja.
                                Žiri će, u toku trajanja takmičenja, nadgledati radove takmičara i po završetku
                                Hakatona doneti konačnu odluku.
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-4">
                        <div class="media" data-aos="fade-up" data-aos-delay="600" data-aos-duration="800">
                            <img class="mr-4" src="https://hakaton.raf.edu.rs/assets/images/icons/Resursi.png" alt="Resursi">
                            <div class="media-body">
                                <h5>Resursi</h5>
                                U toku trajanja hakatona, takmičarima će biti obezbeđena hrana, piće, internet i prostor za zabavu i odmor.
                                Takmičari su u obavezi da donesu laptopove na kojima će raditi,
                                dok će im dodatni resursi kao što su monitori, tastature, miševi, papiri itd. biti obezebeđeni.
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Services End -->
    <section class="pricing-table" id="nagrade">
        <div class="container">
            <div class="title text-center">
                <h6>Osvoji</h6>
                <h1 class="title-blue">Nagrade</h1>
            </div>
            <div class="row no-gutters">
                <div class="col-md-4 order-2 order-md-1 reward-custom-padding">
                    <div class="single-pricing text-center second-place" data-aos="fade-up" data-aos-delay="300"
                         data-aos-duration="600">
                        <span>2.</span>
                        <h2 class="mb-3">Drugo mesto</h2>
                        <!-- <p class="desc">Here goes some description</p> -->
                        <img src="https://hakaton.raf.edu.rs/assets/images/crypto/ethereum_cricle.png" alt="Ethereum" class="img-fluid crypto-img">
                        <p class="price mt-3" style="line-height:0.8em;">50 000</p>
                        <p class="currency " style="line-height:0.8em;">dinara</p>
                        <p style="font-size:1.3em;" class="mt-5">U Ethereum kriptovaluti</p>

                        <svg viewBox="0 0 170 193">
                            <path fill-rule="evenodd" fill="#00538f"
                                  d="M39.000,31.999 C39.000,31.999 -21.000,86.500 9.000,121.999 C39.000,157.500 91.000,128.500 104.000,160.999 C117.000,193.500 141.000,201.000 150.000,183.000 C159.000,165.000 172.000,99.000 167.000,87.000 C162.000,75.000 170.000,63.000 152.000,45.000 C134.000,27.000 128.000,15.999 116.000,11.000 C104.000,6.000 89.000,-0.001 89.000,-0.001 L39.000,31.999 Z"/>
                        </svg>
                    </div>
                </div>
                <div class="col-md-4 order-1 order-md-2 reward-custom-padding">
                    <div class="single-pricing text-center first-place" data-aos="fade-up" data-aos-delay="0"
                         data-aos-duration="600">
                        <span>1.</span>
                        <h2 class="mb-3">Prvo mesto</h2>
                        <img src="https://hakaton.raf.edu.rs/assets/images/crypto/bitcoin_circle.png" alt="Bitcoin" class="img-fluid crypto-img">
                        <p class="price mt-3" style="line-height:0.8em;">100 000</p>
                        <p class="currency " style="line-height:0.8em;">dinara</p>
                        <p style="font-size:1.3em;" class="mt-5">U Bitcoin kriptovaluti</p>
                        <!-- <a href="#" class="btn btn-primary">Prijavi se</a> -->
                        <svg viewBox="0 0 170 193">
                            <path fill-rule="evenodd" fill="#00538f"
                                  d="M39.000,31.999 C39.000,31.999 -21.000,86.500 9.000,121.999 C39.000,157.500 91.000,128.500 104.000,160.999 C117.000,193.500 141.000,201.000 150.000,183.000 C159.000,165.000 172.000,99.000 167.000,87.000 C162.000,75.000 170.000,63.000 152.000,45.000 C134.000,27.000 128.000,15.999 116.000,11.000 C104.000,6.000 89.000,-0.001 89.000,-0.001 L39.000,31.999 Z"/>
                        </svg>
                    </div>
                </div>
                <div class="col-md-4 order-3 order-md-3 reward-custom-padding">
                    <div class="single-pricing text-center third-place" data-aos="fade-up" data-aos-delay="600"
                         data-aos-duration="600">
                        <span>3.</span>
                        <h2 class="mb-3">Treće mesto</h2>
                        <img src="https://hakaton.raf.edu.rs/assets/images/crypto/ethereum_cricle.png" alt="Ethereum" class="img-fluid crypto-img">
                        <p class="price mt-3" style="line-height:0.8em;">25 000</p>
                        <p class="currency " style="line-height:0.8em;">dinara</p>
                        <p style="font-size:1.3em;" class="mt-5">U Ethereum kriptovaluti</p>
                        <!-- <a href="#" class="btn btn-primary">Prijavi se</a> -->
                        <svg viewBox="0 0 170 193">
                            <path fill-rule="evenodd" fill="#00538f"
                                  d="M39.000,31.999 C39.000,31.999 -21.000,86.500 9.000,121.999 C39.000,157.500 91.000,128.500 104.000,160.999 C117.000,193.500 141.000,201.000 150.000,183.000 C159.000,165.000 172.000,99.000 167.000,87.000 C162.000,75.000 170.000,63.000 152.000,45.000 C134.000,27.000 128.000,15.999 116.000,11.000 C104.000,6.000 89.000,-0.001 89.000,-0.001 L39.000,31.999 Z"/>
                        </svg>
                    </div>
                </div>

            </div>
            <div class="col-12 mt-5 text-center" style="font-size:1.3em;">
                <p>
                    Vrednost se obračunava po kursu na dan dodele nagrada.
                </p>
            </div>
        </div>
    </section>
    <!-- Testimonials Start -->

















































    <!-- Testimonials End -->
    <!-- Recent Posts Start -->
    <section class="recent-posts sponsors" id="partneri">
        <div class="container">
            <div class="title text-center">
                <h6>Zlatni</h6>
                <h1 class="text-white">Partneri</h1>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="single-rpost d-sm-flex align-items-center justify-content-end" data-aos="fade-right"
                         data-aos-duration="800">
                        <div class="post-content text-sm-right">
                            <!-- <time datetime="2019-04-06T13:53">15 Oct, 2019</time> -->
                            <h3><a href="https://opinodo.com/" target="_blank">Opinodo ApS</a></h3>
                            <p>Development, Marketing, Reaserch</p>
                            <a class="post-btn" href="https://opinodo.com/" target="_blank"><i
                                    class="fa fa-arrow-right"></i></a>
                        </div>
                        <div class="post-thumb d-flex justify-content-center">
                            <a href="https://opinodo.com/" target="_blank">
                                <img class="img-fluid" src="https://hakaton.raf.edu.rs/assets/images/sponsors/opinodo_logo_centered.png" alt="Opinodo">
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="single-rpost d-sm-flex align-items-center justify-content-start" data-aos="fade-left"
                         data-aos-duration="800">
                        <div class="post-thumb d-flex justify-content-center">
                            <a href="https://teamcubate.com/" target="_blank">
                                <img class="img-fluid" src="https://hakaton.raf.edu.rs/assets/images/sponsors/teamcubate_logo_centered.png"
                                     alt="Teamcubate">
                            </a>
                        </div>
                        <div class="post-content">
                            <!-- <time datetime="2019-04-06T13:53">15 Oct, 2019</time> -->
                            <h3><a href="https://teamcubate.com/" target="_blank">Teamcubate</a></h3>
                            <p>Financial, Development</p>
                            <a class="post-btn" href="https://teamcubate.com/" target="_blank"><i
                                    class="fa fa-arrow-right"></i></a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="single-rpost d-sm-flex align-items-center justify-content-end" data-aos="fade-right"
                         data-aos-delay="200"
                         data-aos-duration="800">
                        <div class="post-content text-sm-right">
                            <!-- <time datetime="2019-04-06T13:53">15 Oct, 2019</time> -->
                            <h3><a href="https://softwarehaus.io/" target="_blank">Softwarehaus</a></h3>
                            <p>Web Development, UI & UX Design, Marketing</p>
                            <a class="post-btn" href="https://softwarehaus.io/" target="_blank"><i
                                    class="fa fa-arrow-right"></i></a>
                        </div>
                        <div class="post-thumb d-flex justify-content-center">
                            <a href="https://softwarehaus.io/" target="_blank">
                                <img class="img-fluid" src="https://hakaton.raf.edu.rs/assets/images/sponsors/softwarehaus_logo_centered.png"
                                     alt="Softwarehaus">
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="single-rpost d-sm-flex align-items-center justify-content-start" data-aos="fade-left"
                         data-aos-delay="200"
                         data-aos-duration="800">
                        <div class="post-thumb d-flex justify-content-center">
                            <a href="https://raf.edu.rs/" target="_blank">
                                <img class="img-fluid" src="https://hakaton.raf.edu.rs/assets/images/sponsors/raf_logo_centered.png" alt="Raf">
                            </a>
                        </div>
                        <div class="post-content">
                            <!-- <time datetime="2019-04-06T13:53">15 Oct, 2019</time> -->
                            <h3><a href="https://raf.edu.rs/" target="_blank">Računarski fakultet</a></h3>
                            <p>Study, Reasearch, Lab</p>
                            <a class="post-btn" href="https://raf.edu.rs/" target="_blank"><i class="fa fa-arrow-right"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="title text-center">
                <h6 style="padding-top:65px;">Srebrni</h6>
                <h1 class="text-white">Partneri</h1>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="single-rpost d-sm-flex align-items-center justify-content-end" data-aos="fade-right"
                         data-aos-duration="800">
                        <div class="post-content text-sm-right">
                            <!-- <time datetime="2019-04-06T13:53">15 Oct, 2019</time> -->
                            <h3><a href="https://spicefactory.co/" target="_blank">SpiceFactory</a></h3>
                            <p>Digital Product Innovation Agency</p>
                            <a class="post-btn" href="https://spicefactory.co/" target="_blank"><i
                                    class="fa fa-arrow-right"></i></a>
                        </div>
                        <div class="post-thumb d-flex justify-content-center">
                            <a href="https://spicefactory.co/ " target="_blank">
                                <img class="img-fluid" src="https://hakaton.raf.edu.rs/assets/images/sponsors/spicefactory_logo_centered.png" alt="SpiceFactory">
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="single-rpost d-sm-flex align-items-center justify-content-start" data-aos="fade-left"
                         data-aos-duration="800">
                        <div class="post-thumb d-flex justify-content-center">
                            <a href="https://www.toptal.com/" target="_blank">
                                <img class="img-fluid" src="https://hakaton.raf.edu.rs/assets/images/sponsors/toptal_logo_centered.png"
                                     alt="Toptal">
                            </a>
                        </div>
                        <div class="post-content">
                            <!-- <time datetime="2019-04-06T13:53">15 Oct, 2019</time> -->
                            <h3><a href="https://www.toptal.com/" target="_blank">Toptal</a></h3>
                            <p>Freelancing platform</p>
                            <a class="post-btn" href="https://www.toptal.com/" target="_blank"><i
                                    class="fa fa-arrow-right"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- <div class="text-center">
                <a href="#" class="btn btn-primary">See More</a>
            </div> -->
        </div>
    </section>
    <!-- Recent Posts End -->


    <!-- Footer Start -->
    <footer>
        <div class="footer-widgets">
            <div class="container">
                <div class="row">
                    <div class="col-6 col-xl-3">
                        <div class="single-widget contact-widget">
                            <div class="media">
                                <i class="fa fa-map-marker text-white"></i>
                                <div class="media-body ml-3">
                                    <h6>Mesto održavanja</h6>
                                    <a href="https://goo.gl/maps/ycUBttET9eLXqLx29" target="_blank" class="footer-link">Računarski
                                        fakultet, <br>
                                        Knez Mihailova 6/VI</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-xl-3">
                        <div class="single-widget contact-widget">
                            <div class="media">
                                <i class="fa fa-envelope-o text-white"></i>
                                <div class="media-body ml-3">
                                    <h6>Imate pitanja?</h6>
                                    <a href="mailto:hakaton@raf.rs" class="footer-link">hakaton@raf.rs</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-xl-3">
                        <div class="single-widget contact-widget">
                            <div class="media">
                                <i class="fa fa-phone text-white"></i>
                                <div class="media-body ml-3">
                                    <h6>Pozovite nas</h6>
                                    <a href="tel:011 33 48 079" class="footer-link"> 011 33 48 079</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-xl-3">
                        <div class="single-widget contact-widget">
                            <div class="media">
                                <!-- <div class="media-body ml-3"> -->
                                <img style="max-width:150px;" src="https://hakaton.raf.edu.rs/assets/images/Hakaton_logo.png" alt="RAF Hakaton">
                                <!-- </div> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Widgets End -->
    </footer>
    <!-- Footer Endt -->
    <!--jQuery-->

    <script src="https://hakaton.raf.edu.rs/assets/js/jquery-3.3.1.js?id=1_12"></script>
    <script src="https://hakaton.raf.edu.rs/assets/js/bootstrap.bundle.js?id=1_12"></script>

    <script src="https://hakaton.raf.edu.rs/assets/js/aos.js?id=1_12"></script>
    <script src="https://hakaton.raf.edu.rs/assets/js/matrix.js?id=1_12"></script>
    <script src="https://hakaton.raf.edu.rs/assets/js/custom.js?id=1_12"></script>
    <script src="https://hakaton.raf.edu.rs/assets/js/main.js?id=1_12"></script>


    <!--Plugins-->


</body>
</html>
