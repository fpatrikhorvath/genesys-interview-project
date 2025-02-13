package com.genesys.framework.stores;

import com.genesys.framework.selenium.pom.guru99.Guru99HomePage;
import com.genesys.framework.selenium.pom.guru99.Guru99NavBar;
import com.genesys.framework.selenium.pom.guru99.Guru99TooltipPage;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Service;

@ScenarioScope
@Service
public class Guru99Store {
    private final Guru99HomePage guru99HomePage;
    private final Guru99NavBar      guru99NavBar;
    private final Guru99TooltipPage guru99TooltipPage;
    public Guru99Store(final Guru99HomePage guru99HomePage, final Guru99NavBar guru99NavBar,
                       final Guru99TooltipPage guru99TooltipPage) {
        this.guru99HomePage = guru99HomePage;
        this.guru99NavBar   = guru99NavBar;
        this.guru99TooltipPage = guru99TooltipPage;
    }

    public Guru99HomePage getGuru99HomePage() {
        return guru99HomePage;
    }

    public Guru99NavBar getGuru99NavBar() {
        return guru99NavBar;
    }

    public Guru99TooltipPage getGuru99TooltipPage() {
        return guru99TooltipPage;
    }
}
