from selenium import webdriver
from selenium.common import NoSuchElementException
from selenium.webdriver.chrome.service import Service
import logging

from selenium.webdriver.common.by import By

logger = logging.getLogger('simple_example')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

driver = webdriver.Firefox(service=Service('/usr/local/bin/geckodriver'))
logger.info('Przechodzę na stronę Teufel')
driver.get('https://teufelaudio.pl/')
cookies = driver.find_element(By.XPATH, "//form[@id='data-privacy-settings']/div[3]/button")
logger.info('Klikam zaakceptuj wszystko')
cookies.click()
sale = driver.find_element(By.CSS_SELECTOR, 'a.custom-tabs__link')
logger.info('Klikam w zakładkę Topseller')
sale.click()
driver.find_element(By.CSS_SELECTOR, "li.custom-tabs__content:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > article:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h3:nth-child(1)").click()
logger.info('Klikam w produkt Cinebar 11 2.1-Set')
driver.find_element(By.ID, "add-to-cart-submit-ajax").click()
driver.get("https://teufelaudio.pl/cart")
try:
    driver.find_element(By.CSS_SELECTOR, "div.product-item > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > volume-price:nth-child(1) > span:nth-child(1)")
    logger.info("Element znajduje się w koszyku")
except NoSuchElementException:
    logger.error("Test failed.")
driver.close()
