package KiyohimeMod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;

import KiyohimeMod.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;

public class AndSoTheShipConquers extends CustomCard {

    public static final String ID = "KiyohimeMod:AndSoTheShipConquers";
    public static final String IMG_PATH = "Kiyohime/images/cards/AndSoTheShipConquers.png";
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    private static final int COST = 2;
    private static final int BLOCK = 7;
    private static final int UPGRADE_PLUS_BLOCK = 3;

    public AndSoTheShipConquers() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Kiyohime_Color,
                AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.SELF);
        this.block = this.baseBlock = BLOCK;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, this.block));
        AbstractDungeon.actionManager
                .addToBottom(new ApplyPowerAction(p, p, new NextTurnBlockPower(p, this.block), this.block));
    }

    public AbstractCard makeCopy() {
        return new AndSoTheShipConquers();
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeBlock(UPGRADE_PLUS_BLOCK);
        }
    }
}