import { ReactComponent as GitHubIcon } from 'assets/img/github.svg';
import './styles.css';

function Navbar() {

    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1 className="dsmovie-contact-title">DSmovie</h1>
                    <a href="https://github.com/ThiagoBertachini">
                        <div className="dsmovie-contact-container">
                            <GitHubIcon />
                            <p className="dsmovie-contact-link">/Bertachini</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );

}
export default Navbar;