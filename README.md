# btc-price-watch :chart:

## welcome to [my](https://github.com/taeyangcode) project, **bitcoin-price-watch**

### purpose:
this is my first time messing around with any sort of web scraping and more specifically `Jsoup`

i've been particularly interested in bitcoin since the second halving, and started observing it seriously after its third halving

the pure identity of a decentralized currency still interests me everyday which was the main inspiration for the creation of this project

### what does it do?
simply put, every 10 seconds (adjustable using `ScheduledExecutorService`) using [cryptowatch](https://cryptowat.ch/)'s displayed prices, i print out the live price of bitcoin to the console

using `Jsoup` to particularly target the `<span>` where the price is located along with other classes, a cleanly printed and spaced price of bitcoin is displayed
