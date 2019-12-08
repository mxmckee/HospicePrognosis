# Hospice Prognostic Estimator

This application will allow a user to generate a prognosis for a current hospice patient, either the user himself or herself or another. By supplying relevant subjective and objective data, a prognosis will be generated based upon the relative impact of each symptom or value toward a hospice prognosis.

One of three prognoses will be generated: Weeks to months, Days to weeks, or Hours to days. The prognosis will be stored in a database along with a unique prognosis ID number, the user's username, the date the prognosis was generated, and the prognosis itself. The prognosis ID number is the primary key, but the table will be queried conditionally based upon username. All prognoses for a given user may be viewed or cleared.

Regarding the user himself or herself, his or her information will be stored in another database. This information will include a unique username, a password, the user's name, his or her email address, a security question used for password reset, and the answer to said question. Given the functionality of the application, a user may register for a new account, log into an existing account, reset his or her password or other profile information except for username, and delete his or her account.

It is important to note that this application is not intended to be an alternative to interaction with a practicing physician. Rather this application's goal is to enhance the patient-physician communication necessary to make appropriate and informed decisions regarding a patient's health while said patient remains in hospice care.
