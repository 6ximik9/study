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
using System.Diagnostics;

namespace Kursova_Rl_
{
    public partial class FrmTEMATEST : Form
    {
        public static int hide=0;
        public static string DataPath = "Data\\Tema\\";
        public static string ActiveThemes = "";
        public static string lbl;
        public static string xto;       

        //Куди записуються результати
        public static string scoretest1 = "";
        
       
        public static int vidbtn = 0;
        //Тести
        public static int countForm = 0;
        public FrmTEMATEST()
        {
            
            
            InitializeComponent();
        }

        private void lblTema1_Click(object sender, EventArgs e)
        {

        }

        private void FrmTEMATEST_Load(object sender, EventArgs e)
        {
            MaximizeBox = false;
            countForm = 1;
            if (FrmLogin.login == "admin" && FrmLogin.pass == "admin")
            {
                lblPIB.Text = null;
                lblPIB.Text = FrmLogin.User;
                
            }
            else
            {
                IEnumerable<string> a = (File.ReadLines("Data\\User\\UserPIB.txt"));
                int i = 0;
                foreach (string str in a)
                {
                    string[] l = str.Split(' ');

                    if (FrmLogin.User == l[0])
                    {
                        xto = l[1] + " " + l[2];
                    }
                    i++;
                }
                lblPIB.Text = xto;
            }
            if (vidbtn == 0)
            {
                btnZm.Hide();
                btnRezult.Hide();
            }
            else
            {
                btnZm.Show();
                btnRezult.Show();
            }

            IEnumerable<string> strThemes;
            strThemes = Directory.GetDirectories(DataPath);

            int iTmp = 0;
            foreach (string dT in strThemes)
            {

                string[] strTmp= dT.Split('\\');
                string OneThemes = strTmp[strTmp.Length - 1];
                Label lblThemes = new Label();
                
                lblThemes.Name = "OneThemes";
                lblThemes.Parent = pnlThemes;
                lblThemes.Top = 45 * iTmp + 15;
                lblThemes.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
                lblThemes.AutoSize = true;
                lblThemes.Font = new System.Drawing.Font("Monotype Corsiva", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
                lblThemes.Text = OneThemes;
                lblThemes.MouseHover += new System.EventHandler(this.lblThemesOn);
                lblThemes.MouseLeave += new System.EventHandler(this.lblThemesLeave);
                lblThemes.Click += new System.EventHandler(this.lblThemesClick);
                
                iTmp++;
            }
           


        }

        private void FrmTEMATEST_FormClosing(object sender, FormClosingEventArgs e)
        {
            countForm = 0;
        }
        

        private void FrmTEMATEST_ResizeBegin(object sender, EventArgs e)
        {
            Opacity = 0.5;
        }

        private void FrmTEMATEST_ResizeEnd(object sender, EventArgs e)
        {
            Opacity = 1;
        }
        
        private void btnZm_Click(object sender, EventArgs e)
        {
            Process.Start(DataPath);
        }
       
        private void lblThemesOn(object sender, EventArgs e)
        {
            if ((sender as Label).Text!=ActiveThemes) (sender as Label).BackColor = Color.Aqua;

            if (File.Exists(DataPath + (sender as Label).Text + "\\00.jpg"))
                        {
                            pctThemes.Image = Image.FromFile(DataPath + (sender as Label).Text + "\\00.jpg");
                        }
        }

        private void lblThemesLeave(object sender, EventArgs e)
        {
            if ((sender as Label).Text != ActiveThemes) (sender as Label).BackColor = Color.Beige;
        }

         private void lblThemesClick(object sender, EventArgs e)
        {
           

            foreach (Label ll in pnlThemes.Controls)
            {
                if ((ll as Label).Text== ActiveThemes) (ll as Label).BackColor = Color.Beige;

            }

            (sender as Label).BackColor = Color.Gold;
            ActiveThemes = (sender as Label).Text;
            lbl1.Text = ActiveThemes;
            if (lbl1.Text != "")
            {
                btnPochTema.BackColor = Color.Lime;
                btnPochTest.BackColor = Color.Lime;
                Pleas.Hide();
            }
        }

        private void pnlThemes_Paint(object sender, PaintEventArgs e)
        {

        }

        private void btnPochTema_Click(object sender, EventArgs e)
        {
                
            
        }
        
        

        private void btnPochTest_Click(object sender, EventArgs e)
        {
            if (lbl1.Text != "")
            {
                lbl = lbl1.Text;
                if (FrmTest.countForm == 0)
                    {
                    if (File.Exists(DataPath + lbl1.Text + "\\Test.txt"))
                    {
                        scoretest1 = DataPath + lbl1.Text + "\\Scores.txt";
                        FrmTest.scoretest = scoretest1;
                        FrmTest.test = DataPath + lbl1.Text + "\\Test.txt";
                        this.Close();
                        FrmTest test = new FrmTest();
                        test.Show();
                    }
                    else
                    {
                        MessageBox.Show("Файл для запису результатів пошкоджено, перевірте наявність файлу <Score.txt>");
                    }
                }
            }
            else 
                    {
                        MessageBox.Show("Виберіть тему");
                    }
        }

        private void btnRezult_Click(object sender, EventArgs e)
        {
            
            if (lbl1.Text != "")
            {
                if (FrmTema.countForm == 0)
                {
                    hide = 1;
                    FrmTema.tema = DataPath + lbl1.Text + "\\Scores.txt";
                    FrmTema.tema = File.ReadAllText(FrmTema.tema, Encoding.GetEncoding(1251));
                    FrmTema poc = new FrmTema();
                    poc.Show();
                   
                }

            }
            else
            {
                MessageBox.Show("Виберіть тему");
            }
        }

        private void btnCance_Click(object sender, EventArgs e)
        {
            lbl1.Text = null;
            Pleas.Show();
            pctThemes.Image = null;
            btnPochTema.BackColor = Color.Crimson;
            btnPochTest.BackColor = Color.Crimson;
            foreach (Label ll in pnlThemes.Controls)
            {
                if ((ll as Label).Text == ActiveThemes) (ll as Label).BackColor = Color.Beige;

            }

        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Close();
            countForm = 0;
        }

        private void pctFon_Click(object sender, EventArgs e)
        {

        }

        private void btnPochTema_Click_1(object sender, EventArgs e)
        {
            if (lbl1.Text != "")
            {
                lbl = lbl1.Text;
                if (FrmTema.countForm == 0)
                {
                    if (File.Exists(DataPath + lbl1.Text + "\\Tema.txt"))
                    {
                        FrmTema.tema = DataPath + lbl1.Text + "\\Tema.txt";
                        FrmTema.lbl = File.ReadAllText(FrmTema.tema, Encoding.Default);
                        Close();
                        FrmTema tema = new FrmTema();
                        tema.Show();
                    }
                }

            }
            else
            {
                MessageBox.Show("Виберіть тему");
            }
        }

        private void btnRandomTest_Click(object sender, EventArgs e)
        {
            if (FrmConfig.countForm == 0)
            {
                this.Hide();
                FrmConfig tema = new FrmConfig();
                tema.Show();
              //  this.Hide();
            }

        }
    }
}
