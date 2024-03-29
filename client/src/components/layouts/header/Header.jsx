import React, {useState} from 'react';
import classes from "./Header.module.css";
import NavBar from "../navbar/NavBar";
import {NavLink, Route, Routes} from "react-router-dom";

const Header = () => {

    const [active, setActive] = useState(false)

    return (
        <div className={classes.header}>
            <div className={classes.headerMenu}>
                <div className={classes.leftMenu}>
                    <button onClick={() => setActive(!active)} className={classes.navBar}>
                        <NavBar active={active} setActive={setActive}/>
                    </button>
                    <div className={classes.city}>
                        <div className={classes.citySelect}>в ресторане</div>
                        <NavLink to={'/map'} className={classes.selectedCity}>Для заказа выберите ресторан</NavLink>
                    </div>
                    <div className={classes.search}>
                        <input className={classes.searchInput} placeholder='Введите название блюда' type="text"/>
                    </div>
                    <div className={classes.logo}>
                        <NavLink to={'/'}>
                            <img
                                src="https://web-static.burgerkingrus.ru/master/25190/_nuxt/85fa0a1c71a8bba230f5de81e911c609.svg"/>
                        </NavLink>
                    </div>
                </div>
                <div className={classes.rightMenu}>
                    <a href='' className={classes.coupons}>
                        Купоны
                    </a>
                    <NavLink to={'/king-club'} className={classes.club}>King club</NavLink>
                    <NavLink to={'/profile'} className={classes.profile}/>
                    <div className={classes.cart}>
                        <button className={classes.cartBtn}></button>
                    </div>
                </div>
            </div>
        </div>
    )
        ;
};

export default Header;