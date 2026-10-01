<!DOCTYPE html>

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Patient Registration</title>
  
  
     

</head>
<body>
    <style >
    :root {
  --bg: #eef3f4;
  --paper: #ffffff;
  --ink: #16282c;
  --muted: #5d7276;
  --line: #cfdcde;
  --accent: #0e6f78;
  --accent-dark: #0a545b;
  --danger: #b3261e;
  --ok: #1d7a46;
}

* { box-sizing: border-box; }

body {
  margin: 0;
  font-family: "Segoe UI", system-ui, -apple-system, sans-serif;
  background: var(--bg);
  color: var(--ink);
  line-height: 1.5;
}

.page {
  max-width: 820px;
  margin: 0 auto;
  padding: 24px 16px 48px;
}

.form,
.records {
  background: var(--paper);
  border: 1px solid var(--line);
  border-top: 6px solid var(--accent);
  border-radius: 8px;
  padding: 28px;
}

.records { margin-top: 24px; border-top-width: 1px; }

h1 { margin: 0 0 4px; font-size: 1.6rem; }
h2 { margin: 0 0 12px; font-size: 1.2rem; }
.intro { margin: 0 0 24px; color: var(--muted); }

.grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 18px 24px;
}

.field { display: flex; flex-direction: column; }

label {
  font-weight: 600;
  font-size: 0.92rem;
  margin-bottom: 6px;
}

input,
select {
  font: inherit;
  padding: 10px 12px;
  border: 1px solid var(--line);
  border-radius: 6px;
  background: #fff;
  color: var(--ink);
}

input:focus,
select:focus {
  outline: 3px solid rgba(14, 111, 120, 0.3);
  border-color: var(--accent);
}

input[readonly] {
  background: #f2f6f7;
  font-weight: 600;
  letter-spacing: 0.04em;
}

.field.invalid input,
.field.invalid select { border-color: var(--danger); }

.error {
  min-height: 1.1em;
  margin-top: 4px;
  color: var(--danger);
  font-size: 0.8rem;
}

.actions {
  display: flex;
  gap: 12px;
  margin-top: 24px;
}

.btn {
  font: inherit;
  font-weight: 600;
  padding: 10px 20px;
  border-radius: 6px;
  border: 1px solid var(--line);
  background: #fff;
  color: var(--ink);
  cursor: pointer;
}

.btn:hover { background: #f2f6f7; }

.btn.primary {
  background: var(--accent);
  border-color: var(--accent);
  color: #fff;
}

.btn.primary:hover { background: var(--accent-dark); }

.btn:focus-visible { outline: 3px solid rgba(14, 111, 120, 0.4); outline-offset: 2px; }

.message { margin: 16px 0 0; font-weight: 600; }
.message.success { color: var(--ok); }
.message.fail { color: var(--danger); }

.table-wrap { overflow-x: auto; }

table { width: 100%; border-collapse: collapse; font-size: 0.9rem; }
th, td { text-align: left; padding: 8px 10px; border-bottom: 1px solid var(--line); white-space: nowrap; }
th { background: #f2f6f7; }

@media (max-width: 600px) {
  .grid { grid-template-columns: 1fr; }
  .form, .records { padding: 20px; }
  .actions { flex-direction: column; }
}

  


</style>
  <main class="page">
    <form id="patientForm" class="form" novalidate>
      <h1>Registration of a patient</h1>
      <p class="intro">Fill in every field. Your Patient ID is created for you.</p>

      <div class="grid">
        <!-- Left column -->
        <div class="field">
          <label for="name">Name</label>
          <input type="text" id="name" name="name" autocomplete="name" required />
          <small class="error"></small>
        </div>

        <div class="field">
          <label for="mentalStatus">Mental status</label>
          <select id="mentalStatus" name="mentalStatus" required>
            <option value="">Select…</option>
            <option>Stable</option>
            <option>Anxious</option>
            <option>Depressed</option>
            <option>Confused</option>
            <option>Other</option>
          </select>
          <small class="error"></small>
        </div>

        <div class="field">
          <label for="age">Age</label>
          <input type="number" id="age" name="age" min="0" max="120" required />
          <small class="error"></small>
        </div>

        <div class="field">
          <label for="healthStatus">Health status</label>
          <select id="healthStatus" name="healthStatus" required>
            <option value="">Select…</option>
            <option>Good</option>
            <option>Fair</option>
            <option>Critical</option>
            <option>Chronic condition</option>
          </select>
          <small class="error"></small>
        </div>

        <div class="field">
          <label for="weight">Weight (kg)</label>
          <input type="number" id="weight" name="weight" min="1" max="400" step="0.1" required />
          <small class="error"></small>
        </div>

        <div class="field">
          <label for="address">Address</label>
          <input type="text" id="address" name="address" autocomplete="street-address" required />
          <small class="error"></small>
        </div>

        <div class="field">
          <label for="gender">Gender</label>
          <select id="gender" name="gender" required>
            <option value="">Select…</option>
            <option>Female</option>
            <option>Male</option>
            <option>Other</option>
          </select>
          <small class="error"></small>
        </div>

        <div class="field">
          <label for="phone">Phone number</label>
          <input type="tel" id="phone" name="phone" autocomplete="tel" placeholder="e.g. 0712345678" required />
          <small class="error"></small>
        </div>

        <div class="field">
          <label for="nextOfKin">Next of kin</label>
          <input type="text" id="nextOfKin" name="nextOfKin" required />
          <small class="error"></small>
        </div>

        <div class="field">
          <label for="patientId">Patient ID</label>
          <input type="text" id="patientId" name="patientId" readonly />
        </div>
      </div>

      <div class="actions">
        <button type="submit" class="btn primary">Register patient</button>
        <button type="reset" class="btn">Clear form</button>
      </div>

      <p id="message" class="message" role="status" aria-live="polite"></p>
    </form>

    <section class="records" id="records" hidden>
      <h2>Registered patients</h2>
      <div class="table-wrap">
        <table>
          <thead>
            <tr>
              <th>ID</th><th>Name</th><th>Age</th><th>Gender</th>
              <th>Phone</th><th>Health</th>
            </tr>
          </thead>
          <tbody id="recordsBody"></tbody>
        </table>
      </div>
    </section>
  </main>

  
</body>
</html>
