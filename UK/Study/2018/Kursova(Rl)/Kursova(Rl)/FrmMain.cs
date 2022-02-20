using System;
using System.IO;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Threading;

namespace Kursova_Rl_
{
    public partial class FrmMain : Form
    {
        private const string MainFon = "Data\\Fon\\FonMain.jpg";

        public FrmMain()
        {
            InitializeComponent();
        }

        private void FrmMain_Load(object sender, EventArgs e)
        {
            MinimizeBox = false;
            for (int i = 0; i < 10; i++)
            {
                Thread.Sleep(60);
                this.Opacity = this.Opacity - 0.1;
            }
            for (int i = 0; i < 10; i++)
            {
                Thread.Sleep(60);
                this.Opacity = this.Opacity + 0.1;
            }
            //Кнопки й контейнер
            btnLogin.Parent = pctBoxFonMain;
            btnRegistration.Parent = pctBoxFonMain;
            btnExit.Parent = pctBoxFonMain;
            btnRegistration.BackColor = Color.Transparent;
            btnLogin.BackColor = Color.Transparent;
            btnExit.BackColor = Color.Transparent;



            //Фон
            try
            {
                pctBoxFonMain.Image = Image.FromFile(MainFon);
            }
            catch(Exception ex)
            {
                MessageBox.Show("Перевірте наявність файлів");
            }
            //Текст Математичний диктант
            lblMainNazv.Parent = pctBoxFonMain;
            lblMainNazv.BackColor = Color.Transparent;
            lblMainNazv.Dock = DockStyle.Fill;
            lblMainNazv.TextAlign = ContentAlignment.TopCenter;
            //Текст вступу
            lblVstup.Parent = pctBoxFonMain;
            lblVstup.BackColor = Color.Transparent;
            


        }

        private void lblVstup_Click(object sender, EventArgs e)
        {

        }

        private void lblMainNazv_Click(object sender, EventArgs e)
        {
            
        }

        private void btnRegistration_Click(object sender, EventArgs e)
        {
            if (FrmReg.countForm == 0)
            {
                FrmReg reg = new FrmReg();
                reg.Show();
            }
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            if (FrmLogin.countForm == 0&&FrmTEMATEST.countForm==0)
            {
                FrmLogin log = new FrmLogin();
                log.Show();
            }
        }

        private void btnRegistration_Move(object sender, EventArgs e)
        {
           //Колір форми при загрузці
        }

        private void btnRegistration_MouseEnter(object sender, EventArgs e)
        {
            btnRegistration.BackColor = Color.Violet;
        }

        private void btnRegistration_MouseLeave(object sender, EventArgs e)
        {
            btnRegistration.BackColor = Color.Transparent;
        }

        

        private void btnLogin_MouseEnter(object sender, EventArgs e)
        {
            btnLogin.BackColor = Color.Violet;
        }
        private void btnLogin_MouseLeave(object sender, EventArgs e)
        {
            btnLogin.BackColor = Color.Transparent;
        }

        private void btn1_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void btnExit_MouseEnter(object sender, EventArgs e)
        {
            btnExit.BackColor = Color.Violet;
        }

        private void btnExit_MouseEnter_1(object sender, EventArgs e)
        {
            btnExit.BackColor = Color.Violet;
        }

        private void btnExit_MouseLeave(object sender, EventArgs e)
        {
            btnExit.BackColor = Color.Transparent;
        }
    }
}
