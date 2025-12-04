// Personel Ekle
function addEmployee() {
  const emp = {
    ad: document.getElementById("empAd").value,
    soyad: document.getElementById("empSoyad").value,
    maas: parseFloat(document.getElementById("empMaas").value),
  };

  fetch("/api/employees/add", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(emp),
  })
    .then((r) => r.json())
    .then((data) => alert("Personel eklendi! ID: " + data.id))
    .catch((err) => alert("Hata: " + err));
}

// Gelmediği Gün Sayısını Güncelle
function updateGelmediGun() {
  const id = parseInt(document.getElementById("gelmediEmpId").value);
  const gun = parseInt(document.getElementById("gelmediGun").value);

  if (!id || isNaN(gun) || gun < 0) {
    alert("Personel ID ve geçerli bir gün sayısı girin!");
    return;
  }

  fetch(`/api/employees/update-gelmedigi-gun/${id}?gun=${gun}`, {
    method: "PUT",
  })
    .then((r) => r.text())
    .then((msg) => {
      alert(msg);
      hesaplaAylikMaas(); // tabloyu otomatik güncelle
      listEmployees();
    })
    .catch((err) => alert("Hata: " + err));
}

// Avans Ver
function giveAvans() {
  const id = document.getElementById("avansEmpId").value;
  const tutar = parseFloat(document.getElementById("avansTutar").value);

  fetch(`/api/avans/give/${id}?tutar=${tutar}`, { method: "POST" })
    .then((r) => r.json())
    .then(() => {
      alert("Avans verildi!");
      hesaplaAylikMaas(); // tablo otomatik güncellensin
    })
    .catch((err) => alert("Hata: " + err));
}

// Aylık Maaşları Hesapla ve Tabloya Yazdır
function hesaplaAylikMaas() {
  fetch("/api/maas/hesapla-aylik")
    .then((r) => r.json())
    .then((list) => {
      let table = `
        <tr>
            <th>ID</th>
            <th>Ad Soyad</th>
            <th>Aylık Maaş</th>
            <th>Toplam Avans</th>
            <th>Gelmediği Gün</th>
            <th>Net Maaş</th>
        </tr>
      `;

      list.forEach((m) => {
        table += `
          <tr>
              <td>${m.employeeId}</td>
              <td>${m.employeeName}</td>
              <td>${m.aylikMaas}</td>
              <td>${m.toplamAvans}</td>
              <td>${m.gelmedigiGun}</td>
              <td>${m.netMaas}</td>
          </tr>
        `;
      });

      document.getElementById("maasTable").innerHTML = table;
    })
    .catch((err) => alert("Hata: " + err));
}

// Personelleri Listele
function listEmployees() {
  fetch("/api/employees/list")
    .then((r) => r.json())
    .then((list) => {
      let table =
        "<tr><th>ID</th><th>Ad</th><th>Soyad</th><th>Maaş</th><th>Gelmediği Gün</th></tr>";
      list.forEach((emp) => {
        table += `<tr>
                        <td>${emp.id}</td>
                        <td>${emp.ad}</td>
                        <td>${emp.soyad}</td>
                        <td>${emp.maas}</td>
                        <td>${emp.gelmedigiGun || 0}</td>
                    </tr>`;
      });
      document.getElementById("employeeTable").innerHTML = table;
    })
    .catch((err) => alert("Hata: " + err));
}

// Kişi bazlı avans sil
function deleteEmployeeAvans() {
  const id = document.getElementById("deleteEmpId").value;

  if (!id) {
    alert("Personel ID girin!");
    return;
  }

  fetch(`/api/avans/delete/${id}`, { method: "DELETE" })
    .then((r) => r.text())
    .then((msg) => {
      alert(msg);
      hesaplaAylikMaas();
    });
}

// Tüm avansları sil
function deleteAllAvans() {
  if (!confirm("Tüm avanslar silinecek! Emin misiniz?")) return;

  fetch("/api/avans/delete-all", { method: "DELETE" })
    .then((r) => r.text())
    .then((msg) => {
      alert(msg);
      hesaplaAylikMaas();
    });
}
