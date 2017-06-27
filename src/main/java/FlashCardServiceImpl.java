
class FlashCardServiceImpl implements FlashCardService {

    private CardDeck cardDeck;

    public FlashCardServiceImpl(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }

    @Override
    public Question nextQuestion() {
        System.out.println("Something");
        return cardDeck.getCard();
    }
}