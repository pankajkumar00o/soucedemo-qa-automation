# SauceDemo QA Automation (Java)

A small browser-based QA automation project that exercises a demo e-commerce site's main user flows.

## Tech stack

- Java 17+
- Selenium WebDriver 4.49.0
- TestNG 7.12.0
- Maven
- Chrome / Chromium (Selenium Manager resolves the matching driver)

## Test coverage

1. **Successful login** — valid user reaches the Products page.
2. **Locked-out login** — locked-out user sees the expected error message.
3. **Add to cart** — cart badge increments and the selected product is present in the cart.
4. **Price sorting** — sorting low-to-high places the least expensive product first.

The automated test case details are in [`docs/test-cases.md`](docs/test-cases.md).

## Run locally

Prerequisites: Java 17 or newer, Maven 3.8+, and Google Chrome or Chromium installed.

```bash
mvn test
```

By default, Chrome runs headlessly. To show the browser window:

```bash
mvn test -Dheadless=false
```

To point the suite at another compatible test environment:

```bash
mvn test -DbaseUrl=https://www.saucedemo.com
```

TestNG and Maven Surefire reports are generated under `target/surefire-reports/`.

## Project layout

```text
src/test/java/com/qa/saucedemo/
├── base/       # Browser setup and shared test lifecycle
├── pages/      # Page Object Model classes
└── tests/      # TestNG test cases
src/test/resources/testng.xml
```

## Notes

- Target: [SauceDemo](https://www.saucedemo.com/), a public demo application.
- Demo credentials used by these tests are public sample credentials: `standard_user` / `secret_sauce` and `locked_out_user` / `secret_sauce`.
- The tests require internet access to reach the demo site. Selenium Manager may need internet access the first time it downloads a browser driver.
- This is an educational test suite, not a claim of exhaustive testing or production certification.
